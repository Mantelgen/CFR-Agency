package ro.mpp2025.proiectiss.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.apache.commons.logging.Log;
import org.controlsfx.control.textfield.TextFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import ro.mpp2025.proiectiss.AutoCompleteTextField;
import ro.mpp2025.proiectiss.BootApplication;
import ro.mpp2025.proiectiss.Domain.Station;
import ro.mpp2025.proiectiss.Domain.Train;
import ro.mpp2025.proiectiss.Domain.User;
import ro.mpp2025.proiectiss.Service.SessionService;
import ro.mpp2025.proiectiss.Service.UserService;
import ro.mpp2025.proiectiss.SpringContextHelper;

import java.io.IOException;
import java.util.List;

@Component
public class MainController {

    private final SessionService sessionService;

    private UserService userService;

    @FXML
    private ImageView homeImage;

    @FXML
    private ImageView searchImage;

    @FXML
    private Button logoutButton;

    @FXML
    private Text nameLabel;

    @FXML
    private Button searchButton;

    @FXML
    private TableView<Train> arrivalTable;

    @FXML
    private TableView<Train> departureTable;

    @FXML
    private TableColumn<Train, String> trainIdColumn;
    @FXML
    private TableColumn<Train, String> departureTimeColumn;
    @FXML
    private TableColumn<Train, String> stationColumn;
    @FXML
    private TableColumn<Train, String> trainTypeColumn;

    @FXML
    private TableColumn<Train, String> trainIdDepColumn;
    @FXML
    private TableColumn<Train, String> departureTimeDepColumn;
    @FXML
    private TableColumn<Train, String> destinationColumn;
    @FXML
    private TableColumn<Train, String> trainTypeDepColumn;

    @FXML
    private AutoCompleteTextField departureField;


    @Autowired
    public MainController(UserService userService, SessionService sessionService) {
        this.userService = userService;
        this.sessionService = sessionService;
    }
    // Example method to initialize the application
    @FXML
    public void initialize() {
        // Load images or perform any other initialization tasks
        homeImage.setImage(new ImageView("/ro/mpp2025/proiectiss/Images/home.png").getImage());
        searchImage.setImage(new ImageView("/ro/mpp2025/proiectiss/Images/search.png").getImage());
       User user = sessionService.getCurrentUser();
        if (user != null && nameLabel != null) {
            nameLabel.setText("Logged in as: " + user.getUsername());
        }
        List<Station> stations = userService.getAllStations();

        departureField.setSuggestions(stations.stream()
                .map(Station::getName)
                .toList());

        trainIdColumn.setCellValueFactory(cellData -> cellData.getValue().trainNumberProperty());
        departureTimeColumn.setCellValueFactory(cellData -> cellData.getValue().arrivalTimeProperty());
        stationColumn.setCellValueFactory(cellData -> cellData.getValue().routeDepartureProperty()); // assuming Route has a property for the station
        trainTypeColumn.setCellValueFactory(cellData -> cellData.getValue().trainTypeProperty());

        // Set up columns for departure table
        trainIdDepColumn.setCellValueFactory(cellData -> cellData.getValue().trainNumberProperty());
        departureTimeDepColumn.setCellValueFactory(cellData -> cellData.getValue().departureTimeProperty());
        destinationColumn.setCellValueFactory(cellData -> cellData.getValue().routeArrivalProperty()); // assuming Route has a destination property
        trainTypeDepColumn.setCellValueFactory(cellData -> cellData.getValue().trainTypeProperty());



    }


    public void handleLogout(ActionEvent event) throws IOException {
        sessionService.clear();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ro/mpp2025/proiectiss/login-view.fxml"));
        loader.setControllerFactory(SpringContextHelper.getContext()::getBean); // Spring controller
        Scene scene = new Scene(loader.load());

        LoginController loginController = loader.getController();
        loginController.setUserService(userService); // If still needed

        Stage newStage = new Stage();
        newStage.setTitle("Login");
        newStage.setScene(scene);
        newStage.show();

        Stage currentStage = (Stage) logoutButton.getScene().getWindow();
        currentStage.close();

    }
    public void handleSearch(ActionEvent event) {
        String stationName = departureField.getText();
        if (stationName != null && !stationName.isEmpty()) {
            List<Train> arrivalTrains = userService.getArrivals(stationName);
            List<Train> departureTrains = userService.getDepartures(stationName);

            ObservableList<Train> arrivalData = FXCollections.observableArrayList(arrivalTrains);
            ObservableList<Train> departureData = FXCollections.observableArrayList(departureTrains);

            arrivalTable.setItems(arrivalData);
            departureTable.setItems(departureData);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter a station name.", ButtonType.OK);
            alert.showAndWait();
        }
    }
}
