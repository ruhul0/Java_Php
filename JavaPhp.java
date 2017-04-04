import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class JavaPhp {
    public static void main(String[] args) {
        ServerSocket s1 = null;
        Socket s = null;
        try {
            s1 = new ServerSocket(1234);

            while (true) {
                s = s1.accept();
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                String line = br.readLine();
                bw.write("Java client Connected\n");
                System.out.println(br.readLine());
                bw.flush();
                bw.close();
                br.close();
                s.close();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}