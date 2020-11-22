import java.io.IOException;
import java.util.*;
import java.util.Map;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.reduce.IntSumReducer;

public class wordCountProj {
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
                if(str.length() > 3) {
                    word.set(str);
                    context.write(word, new IntWritable(1));
                }
            }
        }
    }

    public static class MyMapper2 extends Mapper<LongWritable, Text, Text, IntWritable>{
        private Text word = new Text();
        public void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            // Splitting the line on spaces
            String[] stringArr = value.toString().split("[\\p{Punct}\\s]+");
            for (String str : stringArr) {
                if(str.length() > 3) {
                    word.set(str);
                    context.write(word, new IntWritable(1));
                }
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
                if(str.length() > 3) {
                    word.set(str);
                    context.write(word, new IntWritable(1));
                }
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
            //String wordAndDoc = (key.toString() + " " + context.getFileClassPaths().toString());
            tmap2.put(key.toString(), sum);
        }
        @Override
        public void cleanup(Context context) throws IOException,
                InterruptedException
        {

           // JobConf jc = context.getConfiguration().ge
            String fileName;
            for (Map.Entry<String, Integer> entry : tmap2.entrySet())
            {
                //String[]split = entry.getKey().split(" ");
                if(entry.getKey().equals(searchTerm)) {
                    tmap3.put(entry.getKey(), entry.getValue());

                }
            }
            for(Map.Entry<String, Integer> s: tmap3.entrySet()){
                IntWritable count = new IntWritable(s.getValue());
                String name = s.getKey();
                context.write(new Text(name), count);
            }
        }

        @Override
        protected void setup(Context context) throws IOException, InterruptedException {
            Configuration c = context.getConfiguration();
            searchTerm = c.get("termArg");
        }
    }



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
        //private String wordAndDoc;
        private String word;
        private String doc;
        private int count;

        public SearchResult(String wordAndDoc, int count) {
            String split[] = wordAndDoc.split(" ");

            this.word = split[1];
            this.doc = split[2];
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
        conf.set("termArg", args[4]);
        searchTerm = args[4];
        Job job = Job.getInstance(conf, "WC");
        //JobConf jc = (JobConf) new JobConf();


        job.setJarByClass(wordCountProj.class);
        job.setMapperClass(MyMapper.class);
        //job.setCombinerClass(IntSumReducer.class);
        job.setReducerClass(MyReducer.class);
        //job.setNumReduceTasks(1);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        conf.set("searchTermArg.property", args[4]);
        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, MyMapper.class);
        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, MyMapper2.class);
        MultipleInputs.addInputPath(job, new Path(args[2]), TextInputFormat.class, MyMapper3.class);
        FileOutputFormat.setOutputPath(job, new Path(args[3]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);


    }
}