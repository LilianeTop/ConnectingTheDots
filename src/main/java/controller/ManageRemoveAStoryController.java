package controller;

import javafx.event.ActionEvent;
import main.Main;

public class ManageRemoveAStoryController {
   /* public void updateAStory(ActionEvent actionEvent) {
        //todo: find out how to retrieve a story from dbCouch and remove it

        //todo: create a popup that asks Do you really want to remove this story?
        Story story = storyListView.getSelectionModel().getSelectedItem();
        if(story == null){
            warningText.setVisible(true);
            warningText.setText("Please select a story to change");
        } else {
            Main.getSceneManager().showStoryListScene();
        }
    }*/
    public void removeAStory(ActionEvent actionEvent) {
    }

    public void returnToMenu(ActionEvent actionEvent) {
        Main.getSceneManager().showWelcomeScene();
    }
}
