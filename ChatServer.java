package chat;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {

    private static Set<PrintWriter> writers = new HashSet<>();

    public static void main(String[] args) {

        System.out.println("Chat Server Running...");

        try (ServerSocket serverSocket = new ServerSocket(59001)) {

            while (true) {
                Socket socket = serverSocket.accept();
                new ClientHandler(socket).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {

        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String name;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {

            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                out = new PrintWriter(socket.getOutputStream(), true);
                out.println("SERVER: Enter your name:");

                name = in.readLine();
                writers.add(out);

                broadcast(name + " joined the chat");

                String message;

                while((message = in.readLine()) != null) {

                    if(message.equalsIgnoreCase("QUIT")) break;

                    broadcast(name + ": "+ message);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally{

                if(out != null) writers.remove(out);
                broadcast(name + " left the chat");

                try {
                    socket.close();
                } catch (IOException e) {}
            }
        }

        private void broadcast(String message) {

            for(PrintWriter writer : writers) {
                writer.println(message);
            }
        }
    }
}