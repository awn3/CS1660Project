import java.io.IOException;
import java.util.*;
import java.util.Map;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class topNProj {
    public static String path1;
    public static String path2;
    public static String path3;
    public static String outputFile;
    public static String searchTerm;
    public static Integer nValue;
    public static TreeMap<String, Integer> tmap2= new TreeMap<String, Integer>();
    public static TreeMap<String, Integer> tmap3= new TreeMap<String, Integer>();
    public static TreeMap<String, Integer> topNmap= new TreeMap<String, Integer>();
    public static SortedSet<WordPairs> sortedResult = new TreeSet<WordPairs>();
    public static ArrayList<SearchResult> searchTermResults = new ArrayList<SearchResult>();
    // Map function
    public static class MyMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
        private Text word = new Text();
        public void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            // Splitting the line on spaces or any punctiation
            String[] stringArr = value.toString().split("[\\p{Punct}\\s]+");
            for (String str : stringArr) {
                word.set(str);
                context.write(word, new IntWritable(1));
            }
        }
    }

    public static class MyMapper2 extends Mapper<LongWritable, Text, Text, IntWritable>{
        private Text word = new Text();
        public void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            // Splitting the line on spaces
            String[] stringArr = value.toString().split("[\\p{Punct}\\s]+");
            //String[] stringArr = value.toString().split("\\s|.|,|\"|!|\\?|\\(|\\)|&|%|;|:");

            for (String str : stringArr) {
                word.set(str);
                context.write(word, new IntWritable(1));
            }
        }
    }
    public static class MyMapper3 extends Mapper<LongWritable, Text, Text, IntWritable>{
        private Text word = new Text();
        public void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            // Splitting the line on spaces
            String[] stringArr = value.toString().split("[\\p{Punct}\\s]+");
            for (String str : stringArr) {
                word.set(str);
                context.write(word, new IntWritable(1));
            }
        }
    }

    // Reduce function
    public static class MyReducer extends Reducer<Text, IntWritable, Text, IntWritable>{
        private IntWritable result = new IntWritable();

        public void reduce(Text key, Iterable<IntWritable> values, Context context)
                throws IOException, InterruptedException {
            int sum = 0;
            for (IntWritable val : values) {
                sum += val.get();
            }
            result.set(sum);
            tmap2.put(key.toString() + " " + context.toString(), result.get());
        }
        @Override
        public void cleanup(Context context) throws IOException,
                InterruptedException
        {
            String fileName;
            for (Map.Entry<String, Integer> entry : tmap2.entrySet())
            {

                IntWritable count = new IntWritable(entry.getValue());
                String name = entry.getKey();
                context.write(new Text(name), count);

            }
        }

    }

    public static void findTopN() {

        //Integer smallestVal = 0;

        for (Map.Entry<String, Integer> entry : tmap2.entrySet())
        {
            String word = entry.getKey();
            int count = entry.getValue();
            WordPairs temp = new WordPairs(word, count);
            sortedResult.add(temp);
            while(sortedResult.size() > nValue) {
                sortedResult.remove(sortedResult.first());
            }
        }
    }

    public static void searchForTerm(String searchTerm) {
        for (Map.Entry<String, Integer> entry : tmap2.entrySet())
        {
            String fullKey = entry.getKey();
            String[] wordDoc = fullKey.split(" ");
            String word = wordDoc[0];
            String doc =wordDoc[1];
            int count = entry.getValue();

            if(searchTerm.equals(word)) {
                SearchResult temp = new SearchResult(word, doc, count);
                searchTermResults.add(temp);
            }


        }
    }

//            	topNmap.put(entry.getKey(), entry.getValue());
//            	String keyToRemove = entry.getKey();
//            	while(topNmap.size > nValue) {
//            		topNmap.remove(topNmap.first());
//            	}
//
//               if(entry.getValue() > smallestVal) {
//
//                   smallestVal = entry.getValue();
//                   keyToRemove = entry.getKey();
//               }
//               topNmap.remove(tmap2.remove(keyToRemove).toString());






    public static class WordPairs implements Comparable<WordPairs>{
        private String word;
        private int count;

        public WordPairs(String word, int count) {
            this.word = word;
            this.count = count;

        }
        public int compareTo(WordPairs obj) {
            if (this == obj) {
                return 0;
            }
            if (this.count < obj.count) {
                return -1;
            } else if (this.count > obj.count) {
                return 1;
            }
            return word.compareTo(obj.word);
        }

        public String toString() {
            return word + " " + count;
        }

    }

    public static class SearchResult implements Comparable<SearchResult>{
        private String word;
        private String doc;
        private int count;

        public SearchResult(String word, String doc, int count) {
            this.word = word;
            this.count = count;

        }
        public int compareTo(SearchResult obj) {
            if (this == obj) {
                return 0;
            }
            if (this.count < obj.count) {
                return -1;
            } else if (this.count > obj.count) {
                return 1;
            }
            return word.compareTo(obj.word);
        }

        public String toString() {
            return word + " " + doc + " " + count;
        }

    }
    //configured for term search
    public static void main(String[] args)  throws Exception{
        Configuration conf = new Configuration();

        Job job = Job.getInstance(conf, "WC");
        job.setJarByClass(topNProj.class);
        job.setMapperClass(MyMapper.class);
        job.setReducerClass(MyReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, MyMapper.class);
        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, MyMapper2.class);
        MultipleInputs.addInputPath(job, new Path(args[2]), TextInputFormat.class, MyMapper3.class);
        FileOutputFormat.setOutputPath(job, new Path(args[3]));
        if(args.length == 4){
            searchTerm = args[4];
        }
        System.exit(job.waitForCompletion(true) ? 0 : 1);

    }
}