package controller;

import javafx.event.ActionEvent;
import main.Main;

public class ManageReadStoriesController {
    public void sortOnDate(ActionEvent actionEvent) {
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
