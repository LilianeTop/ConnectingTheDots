package controller;

import database.mySQL.DBAccess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import model.Story;

public class WelcomeSceneController {
    private DBAccess dbAccess;
    private String role = LoginSceneController.currentRole;

    @FXML
    private Label welcomeLabel;
    @FXML
    private Label subTitle;
    @FXML
    private MenuButton taskMenuButton;

    public void setup(Story story) {
        welcomeLabel.setText("Welcome " + LoginSceneController.currentUser.toString());

    }


    public void doQuit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
