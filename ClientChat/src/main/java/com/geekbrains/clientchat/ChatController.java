package com.geekbrains.clientchat;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.text.DateFormat;
import java.util.Date;

public class ChatController {
    @FXML
    public TextField messageField;
    @FXML
    public Button sendButton;
    @FXML
    public TextArea messageArea;
    @FXML
    public ListView users;

    public void appendMessage(ActionEvent actionEvent) {
        if (!messageField.getText().isEmpty()) {
            messageArea.appendText(DateFormat.getDateTimeInstance().format(new Date()));
            messageArea.appendText(System.lineSeparator());
            if (!users.getSelectionModel().isEmpty()) {
                String sender = users.getSelectionModel().getSelectedItems().toString();
                messageArea.appendText(sender + ": ");
            } else {
                messageArea.appendText("Я: ");
            }
            messageArea.appendText(messageField.getText().trim());
            messageArea.appendText(System.lineSeparator());
            requestFocus();
            messageField.clear();
        }
    }
    private void requestFocus() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                messageField.requestFocus();
            }
        });
    }
}