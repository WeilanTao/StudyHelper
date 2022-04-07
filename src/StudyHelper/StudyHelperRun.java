package StudyHelper;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;


public class StudyHelperRun {

    public static ServerSocket ss;

    public static void main(String[] args) {

        ss = null;

        try {
            ss = new ServerSocket(1044);
        } catch (IOException e) {
            System.err.println("Application already running!");
            System.exit(-1);
        }

        StudyHelper sh = StudyHelper.getInstance();

    }

}
