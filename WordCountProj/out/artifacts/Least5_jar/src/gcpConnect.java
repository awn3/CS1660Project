import java.io.File;
import java.io.IOException;

public class gcpConnect{

    public gcpConnect() throws IOException {
        String connectCMDs [] = {"sh", "-T","/Users/adamnash/WordCountProj/src/gcpConnect.sh"};
        // Process p1 = Runtime.getRuntime().exec(connectCMDs);
        ProcessBuilder pb = new ProcessBuilder(connectCMDs);
        //pb.inheritIO();
        pb.redirectErrorStream(true);
        File log = new File("java-version.log");
        pb.redirectOutput(log);
        pb.start();
    }
}