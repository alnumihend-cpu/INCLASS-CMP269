package chat;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.TextInputDialog;
import java.util.Optional;

import java.io.*;
import java.net.Socket;

public class ChatApp extends Application {

    TextArea chatArea;
    TextField inputField;
    Button sendButton;

    PrintWriter out; //sends message
    
    BufferedReader in;  //receives it 

    @Override
    public void start(Stage stage) {

        chatArea =new TextArea();
        chatArea.setEditable(false);

        inputField =new TextField(); //input firld
        sendButton = new Button("Send"); //send button: A Button to trigger the transmission
        
        HBox bottom= new HBox(10, inputField, sendButton);

        BorderPane root = new BorderPane();
        root.setCenter(chatArea);
        root.setBottom(bottom);

        Scene scene = new Scene(root, 400, 300);
        stage.setTitle("Chat Client");
        stage.setScene(scene);
        stage.show();

        //connectToServer();
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Login");
        dialog.setHeaderText("Enter your name:");

        Optional<String> result =dialog.showAndWait();
        String userName = result.orElse("User");

        connectToServer(userName);
        
        sendButton.setOnAction(e -> sendMessage());
        inputField.setOnAction(e -> sendMessage());
        
        stage.setOnCloseRequest(e -> {
            try {
                if(out != null) {
                    out.println("QUIT");
                }
            } catch(Exception ex) {}
        });
    }

    private void connectToServer(String userName) {
        try {
            Socket socket = new Socket("localhost", 59001);

            out = new PrintWriter(socket.getOutputStream(), true);
            out.println(userName);

            in= new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Thread receiveThread = new Thread(() -> {
                try {
                    String message;
                    while((message = in.readLine()) !=null) {

                        String finalMessage = message;
                        Platform.runLater(() -> {
                            chatArea.appendText(finalMessage + "\n");
                        });
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            receiveThread.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendMessage() {

        String message = inputField.getText();
        if(!message.isEmpty()) {
            out.println(message);
            inputField.clear();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}