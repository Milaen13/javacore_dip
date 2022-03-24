import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) throws IOException {

        String host = "localhost";
        int port = 8089;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            out.println("Mila\n" + "Host: localhost\n\n\n");
            String resp = in.readLine();
            System.out.println(resp);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

