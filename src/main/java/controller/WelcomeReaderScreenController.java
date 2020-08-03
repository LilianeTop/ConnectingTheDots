package controller;

import database.DBAccess;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import main.Main;

public class WelcomeReaderScreenController {
    private DBAccess dbAccess = Main.getDBAccess();
    private String role = LoginSceneController.currentRole;

    @FXML
    private Label welcomeLabel;
    @FXML
    private Label subTitle;
    @FXML
    private MenuButton taskMenuButton;
    @FXML
    private Button logoutButton;

    public WelcomeReaderScreenController() {
        super();
    }

    public void setUp() {
        welcomeLabel.setText("Welcome " + LoginSceneController.currentUser.toString());
        MenuItem newStories = new MenuItem("Latest Stories");
        newStories.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Main.getSceneManager().showNewStories();
            }
        });
        taskMenuButton.getItems().add(newStories);

        MenuItem storiesRead = new MenuItem("Stories you've read");
        storiesRead.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Main.getSceneManager().showReadStories();
            }
        });
        taskMenuButton.getItems().add(storiesRead);
    }

    public void doQuit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void doLogin(ActionEvent actionEvent) {
        Main.getSceneManager().showLoginScene();
    }
}
