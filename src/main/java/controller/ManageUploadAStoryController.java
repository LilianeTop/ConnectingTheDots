package controller;

import javafx.event.ActionEvent;
import main.Main;

public class ManageUploadAStoryController {

    public ManageUploadAStoryController() {
        super();
    }

    public void setUp() {

    }

    public void returnToMenu(ActionEvent actionEvent) {
        Main.getSceneManager().showWelcomeScene();
    }

    public void saveStory(ActionEvent actionEvent) {
        //Todo: upoload story to dbCouch include the details of the storyTeller and publishing date
    }
}


