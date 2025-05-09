package ro.mpp2025.proiectiss.Controller;

import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

@Component
public class MessageAlert {
    public static void showMessage(Stage owner, Alert.AlertType type, String header, String text) {
        Alert message = new Alert(type);
        message.setHeaderText(header);
        message.setContentText(text);
        message.initOwner(owner);
        message.showAndWait();
    }
}
