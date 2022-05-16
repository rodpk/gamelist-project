import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Runnable {

    private final int PORT = 9999;

    private Socket client;
    private BufferedReader in;
    private PrintWriter out;


    @Override
    public void run() {
        try {
            Socket client = new Socket("127.0.0.1", PORT);

        } catch(Exception ex) {
        }
    }
    
}
