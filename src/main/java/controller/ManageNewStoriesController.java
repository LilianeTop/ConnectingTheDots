package controller;

import javafx.event.ActionEvent;
import main.Main;

public class ManageNewStoriesController {
    public void setUp() {
    }

    public void sortOnDate(ActionEvent actionEvent) {
        //Todo: find out how to sort through DBCouch
    }

    public void sortByStoryTeller(ActionEvent actionEvent) {
    }

    public void sortByTitle(ActionEvent actionEvent) {
    }

    public void sortBySubject(ActionEvent actionEvent) {
    }

    public void doQuit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void returnToMenu(ActionEvent actionEvent) {
        Main.getSceneManager().showWelcomeScene();
    }
}
