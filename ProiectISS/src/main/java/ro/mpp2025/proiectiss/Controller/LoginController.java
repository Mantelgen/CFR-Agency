package ro.mpp2025.proiectiss.Controller;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.mpp2025.proiectiss.Domain.User;
import ro.mpp2025.proiectiss.Service.SessionService;
import ro.mpp2025.proiectiss.Service.UserService;
import ro.mpp2025.proiectiss.SpringContextHelper;

import java.io.IOException;
import java.util.Optional;

@Component
public class LoginController {
    @FXML
    private Label welcomeText;

    @FXML
    private ImageView logoImageView;

    @FXML
    private Button loginButton;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private  UserService userService;

    private final SessionService sessionService;

    @Autowired
    public LoginController(UserService userService, SessionService sessionService) {
        this.userService = userService;
        this.sessionService = sessionService;


    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void onClickLogin(ActionEvent event) throws IOException {
        try {
            String username = usernameField.getText();
            String password = passwordField.getText();
            if (username.isEmpty() || password.isEmpty()) {
                throw new IllegalArgumentException("Username and password cannot be empty");
            }
            if (!userService.veirfyLogin(username, password)) {
                throw new IllegalArgumentException("Invalid username or password");
            }

            Optional<User> user = userService.findByUsername(username);
            sessionService.setCurrentUser(user.orElse(null));

            // === Play the animation ===
            TranslateTransition slideLeft = new TranslateTransition(Duration.millis(300), logoImageView);
            slideLeft.setByX(-400); // move logo to the right (adjust +400 if needed)

            slideLeft.setOnFinished(e -> {
                try {
                    // Load the main application window AFTER animation
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/ro/mpp2025/proiectiss/main-view.fxml"));
                    loader.setControllerFactory(SpringContextHelper.getContext()::getBean);
                    Scene scene = new Scene(loader.load());

                    // Create and show new stage
                    Stage newStage = new Stage();
                    newStage.setTitle("Main Application");
                    newStage.setScene(scene);
                    newStage.show();

                    // Close the login window
                    Stage currentStage = (Stage) loginButton.getScene().getWindow();
                    currentStage.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });

            slideLeft.play();

        } catch (IllegalArgumentException e) {
            MessageAlert.showMessage(null, Alert.AlertType.ERROR, "Error", e.getMessage());
        }
    }

    @FXML
    public void initialize() {
        Image logoImage = new Image(getClass().getResourceAsStream("/ro/mpp2025/proiectiss/Images/CFR-Logo.png"));
        logoImageView.setImage(logoImage);



    }
}
