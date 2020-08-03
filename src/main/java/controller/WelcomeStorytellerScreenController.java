package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import main.Main;

public class WelcomeStorytellerScreenController {
    @FXML
    private Label welcomeLabel;

    @FXML
    private MenuButton taskMenuButton;

    public WelcomeStorytellerScreenController() {
        super();
    }

    public void setUp() {
        welcomeLabel.setText("Welcome " + LoginSceneController.currentUser.toString());

        MenuItem addAStory = new MenuItem("Upload a story");
        addAStory.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Main.getSceneManager().showUploadAStory();
            }
        });
        taskMenuButton.getItems().add(addAStory);

        MenuItem changeAStory = new MenuItem("Change a story");
        changeAStory.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Main.getSceneManager().showChangeAStorie();
            }
        });
        taskMenuButton.getItems().add(changeAStory);

        MenuItem removeAStory = new MenuItem("Remove a story");
        removeAStory.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Main.getSceneManager().showRemoveAStorie();
            }
        });
        taskMenuButton.getItems().add(removeAStory);

    }

    public void doQuit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void doLogin(ActionEvent actionEvent) {
        Main.getSceneManager().showLoginScene();
    }
}


