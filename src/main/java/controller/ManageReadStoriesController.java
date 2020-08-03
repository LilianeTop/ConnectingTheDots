package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import main.Main;
import model.Story;

public class ManageReadStoriesController {

    @FXML
    ListView<Story> storyListView;

    public void setUp(){
        //todo: retrieve all stories from dbCouch
    }
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
