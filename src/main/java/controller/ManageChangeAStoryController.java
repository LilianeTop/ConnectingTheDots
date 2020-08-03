package controller;

import database.couchDB.CouchDBAccess;
import database.couchDB.CouchDBStoryDAO;
import database.mySQL.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import main.Main;
import model.Story;

public class ManageChangeAStoryController {
    private CouchDBStoryDAO couchDBStoryDAO;
    private CouchDBAccess couchDBAccess;
    private UserDAO userDAO;

    @FXML
    ListView<Story> storyListView;

    @FXML
    TextField warningText;

    public ManageChangeAStoryController() {
        super();
       // this.couchDBAccess = Main.run();
    }

    public void setUp(){
        this.couchDBStoryDAO = new CouchDBStoryDAO();
        //todo: create a methode to retrieve the stories per storyteller
      /*  for(Story story : couchDBStoryDAO.getAllStoriesByStoryteller(userDAO.getOneByUsername())){
            storyListView.getItems().add(story);
        }*/

    }


    public void updateAStory(ActionEvent actionEvent) {
        //todo: find out how to retrieve a story from dbCouch and update it
        Story story = storyListView.getSelectionModel().getSelectedItem();
        if(story == null){
            warningText.setVisible(true);
            warningText.setText("Please select a story to change");
        } else {
            Main.getSceneManager().showStoryListScene();
        }
    }

    public void returnToMenu(ActionEvent actionEvent) {
        Main.getSceneManager().showWelcomeScene();
    }


}
