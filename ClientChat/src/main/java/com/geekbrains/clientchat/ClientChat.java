package com.geekbrains.clientchat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ClientChat extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ClientChat.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Java FX App");
        stage.setScene(scene);
        ChatController controller = fxmlLoader.getController();
        controller.users.getItems().addAll("Пользователь1", "Пользователь2");
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}