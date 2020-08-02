package controller;

import database.DBAccess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import main.Main;

public class WelcomeAdministratorScreenController {
    private DBAccess dbAccess;
    private String role = LoginSceneController.currentRole;

    @FXML
    private Label welcomeLabel;
    @FXML
    private Label subTitle;
    @FXML
    private MenuButton taskMenuButton;

    public WelcomeAdministratorScreenController() {
        super();
        this.dbAccess = Main.getDBAccess();
    }

    public void setup() {
        welcomeLabel.setText("Welcome " + LoginSceneController.currentUser.toString());


    }



    public void doQuit(ActionEvent actionEvent) {
        System.exit(0);
    }
}

