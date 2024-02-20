
import java.io.*;
import java.net.*;
//import java.nio.Buffer;
import java.util.*;

public class server {
    ServerSocket server;
    Socket socket;

    BufferedReader br;
    PrintWriter out;

    // constructor
    public server() {
        try {
            server = new ServerSocket(2345);
            System.out.println("Server is ready to accept connection");
            System.out.println("Waiting...");
            socket = server.accept();

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out = new PrintWriter(socket.getOutputStream());

            startReading();
            startWriting();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    public void startReading() {
        // thread =read karke deta rahega
        Runnable r1 = () -> {
            System.out.println("Reader Started...");
            try {
                while (true) {

                    String msg = br.readLine();
                    if (msg.equals("exit")) {
                        System.out.println("CLient Terminated the chat..");

                        socket.close();
                        break;
                    }
                    System.out.println("client:" + msg);

                }
            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println("Connection is closed");
            }
        };
        new Thread(r1).start();
    }

    public void startWriting() {
        // thread=data user lega and then send karega client tak
        Runnable r2 = () -> {
            System.out.println("Writer Started...");
            try {
                while (!socket.isClosed()) {

                    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
                    String content = br1.readLine();
                    out.println(content);
                    out.flush();
                    if(content.equals("exit")){
                        socket.close();
                        break;
                    }
                }
            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println("Connection is closed");
            }
            //System.out.println("Connection is closed");

        };

        new Thread(r2).start();
    }

    public static void main(String[] args) {
        System.out.println("This is a server... Going to start Server");
        new server();
    }
}
