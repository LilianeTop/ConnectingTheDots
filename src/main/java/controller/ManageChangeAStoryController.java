package controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import database.couchDB.CouchDBAccess;
import database.couchDB.CouchDBStoryDAO;
import database.mySQL.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import main.Main;
import model.Story;
import model.User;

public class ManageChangeAStoryController {
    private CouchDBStoryDAO couchDBStoryDAO;
    private CouchDBAccess couchDBAccess;
    private UserDAO userDAO;
    private User storyteller;
    private Gson gson;
    private JsonObject jsonObject;

    @FXML
    ListView<Story> storyListView;

    @FXML
    TextField warningText;

    public ManageChangeAStoryController() {
        super();
       // setUp();after deleting this all of a sudden it works

    }

    public void setUp() {
        this.gson = new Gson();
        this.jsonObject = new JsonObject();
        this.couchDBAccess = new CouchDBAccess();
        this.couchDBStoryDAO = new CouchDBStoryDAO(couchDBAccess);
        this.userDAO = new UserDAO(Main.getDBAccess());
        this.storyteller = User.getCurrentUser();
        fillStoryListView();

    }


    public void fillStoryListView() {
        for(Story story : couchDBStoryDAO.getStoriesByStoryteller(this.storyteller)){
            storyListView.getItems().add(story);
        }
    }

    public void updateAStory(ActionEvent actionEvent) {
        //todo: find out how to retrieve all stories from dbCouch
        Story story = storyListView.getSelectionModel().getSelectedItem();
        if (story == null) {
            warningText.setVisible(true);
            warningText.setText("Please select a story to change");
        } else {
            Main.getSceneManager().showStoryListScene(story);
        }
    }

    public void returnToMenu(ActionEvent actionEvent) {
        Main.getSceneManager().showWelcomeScene();
    }


}
