package controller;

import database.DBAccess;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import main.Main;

public class WelcomeSceneController {
    private DBAccess dbAccess;
    private String role = LoginSceneController.currentRole;

    @FXML
    private Label welcomeLabel;
    @FXML
    private Label subTitle;
    @FXML
    private MenuButton taskMenuButton;

    public void setup() {
        MenuItem item1 = new MenuItem("Artikel lezen");
        item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Main.getSceneManager().showStoryListScene();
            }
        });
        taskMenuButton.getItems().add(item1);
        MenuItem item2 = new MenuItem("Artikel toevoegen");
        item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Main.getSceneManager().showAddStoryScene();
            }
        });
        taskMenuButton.getItems().add(item2);
    }

    public void doQuit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
