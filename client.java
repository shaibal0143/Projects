
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class client {
    Socket socket;

    BufferedReader br;
    PrintWriter out;

    public client() {
        try {
            System.out.println("Sending request to Server..");
            socket = new Socket("192.168.29.150", 2345);
            System.out.println("connection done..");

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out = new PrintWriter(socket.getOutputStream());

            startReading();
            startWriting();
        } catch (Exception e) {
            // TODO: handle exception
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
                        System.out.println("Server Terminated the chat..");
                        socket.close();
                        break;
                    }
                    System.out.println("Server:" + msg);
                }
            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println("Connection closed");
            }
        };
        new Thread(r1).start();
    }

    public void startWriting() {
        // thread=dat user lega and then send karega client tak
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
                System.out.println("Connection is closed");
            } catch (Exception e) {
                e.printStackTrace();
            }

        };

        new Thread(r2).start();
    }

    public static void main(String[] args) {
        System.out.println();
        new client();
    }
}