package Homework_4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Button bSendMessage;

    @FXML
    private TextArea taChatMessages;

    @FXML
    private TextField tfInputMessage;

    public void btnSendMessageAction(ActionEvent actionEvent) {
        String message = tfInputMessage.getText();

        if (!message.isEmpty()) {
            message += "\n";

            taChatMessages.appendText(message);

            tfInputMessage.setText("");
        }

        tfInputMessage.requestFocus();
    }
}
