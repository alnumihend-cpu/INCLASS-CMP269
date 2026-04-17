package chat;

import java.io.*;

import java.net.Socket;
import java.util.Scanner;

public class ConsoleClient {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 59001);

            PrintWriter out =new PrintWriter(socket.getOutputStream(),true); //send messages to the server.

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner scanner = new Scanner(System.in);
            
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            out.println(name);
            
            Thread receiveThread = new Thread(() -> {  //check the loop

                try {
                    String message;

                    while((message = in.readLine())!= null) {
                        System.out.println(message);
                    }

                } catch(IOException e) {
                    System.out.println("Disconnected");
                }

            });

            receiveThread.start();

            while(true) {

                String input = scanner.nextLine();

                if(input.equalsIgnoreCase("QUIT")) {
                	out.println("QUIT");
                    socket.close();
                    break;
                }

                out.println(input);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}