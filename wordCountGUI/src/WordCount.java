

import javax.naming.Context;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class WordCount {
    public static String path1;
    public static String path2;
    public static String path3;
    public static String outputFile;
    public static String searchTerm;
    public static Integer nValue;
    public static File log = new File("java-version.log");

    public static void topN() throws IOException {
        path1 = "/textFiles/Miserables.txt";
        path2 = "/textFiles/NotreDame_De_Paris.txt";
        path3 =  "/textFiles/anna_karenhina.txt";
        outputFile = "/textFiles/out46.txt";
        String connectCMDs[] = {"sh", "-T", "/Users/adamnash/wordCountGUI/src/gcpTopNScript.sh", path1, path2, path3, outputFile, nValue.toString()};
        ProcessBuilder pb = new ProcessBuilder(connectCMDs);
        pb.redirectErrorStream(true);
        File log = new File("java-version.log");
        pb.redirectOutput(log);
        Desktop.getDesktop().open(log);
        pb.start();
    }

    public static void searchForTerm() throws IOException {
        path1 = "/textFiles/Miserables.txt";
        path2 = "/textFiles/NotreDame_De_Paris.txt";
        path3 =  "/textFiles/anna_karenhina.txt";
        outputFile = "/textFiles/out46.txt";
        String connectCMDs[] = {"sh", "-T", "/Users/adamnash/wordCountGUI/src/gcpTermSearchScript.sh", path1, path2, path3, outputFile, searchTerm};
        ProcessBuilder pb = new ProcessBuilder(connectCMDs);
        pb.redirectErrorStream(true);
        File log = new File("java-version.log");
        pb.redirectOutput(log);
        Desktop.getDesktop().open(log);

        pb.start();
    }

}
