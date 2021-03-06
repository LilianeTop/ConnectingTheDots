package controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import database.couchDB.CouchDBAccess;
import database.couchDB.CouchDBStoryDAO;
import database.mySQL.DBAccess;
import database.mySQL.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.Main;
import model.Story;
import model.User;

public class ManageUploadAStoryController {
    private User currentUser;
    private Story story;
    private User storyteller;
    private UserDAO userDAO;
    private DBAccess dbAccess;
    private CouchDBAccess couchDBAccess;
    private CouchDBStoryDAO couchDBStoryDAO;
    private Gson gson;

    @FXML
    private Button returnButton;
    @FXML
    private Button uploadButton;
    @FXML
    private Label titleLabel;
    @FXML
    private TextField titleTextfield;
    @FXML
    private TextField subtitleTextfield;
    @FXML
    private TextField subjectTextfield;
    @FXML
    private TextField dateTextfield;
    @FXML
    private TextField summaryTextfield;
    @FXML
    private TextField contentTextfield;


    public ManageUploadAStoryController() {
        super();
        this.couchDBAccess = new CouchDBAccess();
        this.couchDBStoryDAO = new CouchDBStoryDAO(couchDBAccess);
        this.userDAO = new UserDAO(Main.getDBAccess());
        this.storyteller = User.getCurrentUser();
        gson = new Gson();
    }

    public void setUp(Story story) {
       titleLabel.setText("Change your Story");
       titleTextfield.setText(story.getTitle());
       subtitleTextfield.setText(story.getSubTitle());
       subjectTextfield.setText(story.getSubject());
       dateTextfield.setText(story.getDate());
       summaryTextfield.setText(story.getSummary());
       contentTextfield.setText(story.getContent());

    }

    //Todo: how to test this?

    public String saveAStory(Story mpStory) {
        String storyToSave = gson.toJson(mpStory);
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(storyToSave).getAsJsonObject();
        String doc_Id = couchDBAccess.saveDocument(jsonObject);
        return doc_Id;
    }

    @FXML
    public void returnToMenu(ActionEvent actionEvent) {
        Main.getSceneManager().showWelcomeScene();
    }

    @FXML
    public void uploadAStory(ActionEvent actionEvent) {
        createStory(); //works
        saveAStory(story);
        Alert storySaved = new Alert(Alert.AlertType.INFORMATION);
        storySaved.setContentText("Your story has been uploaded");
        storySaved.show();
        Main.getSceneManager().showWelcomeScene();
    }

    private void createStory() {
        StringBuilder warningText = new StringBuilder();
        boolean rightInput = true;
        String title = titleTextfield.getText();
        String subtitle = subtitleTextfield.getText();
        String subject = subjectTextfield.getText();
        //fixme: how to show a calendar that they can pick a date
        //Date date = dateTextfield.g;
        String date = dateTextfield.getText();
        String summary = summaryTextfield.getText();
        String content = contentTextfield.getText();
        //Fixme: how to have tiptools to show what kind of info is expected
        if (title.isEmpty()) {
            warningText.append("Please enter a title\n");
            rightInput = false;
        }
        if (subject.isEmpty()) {
            warningText.append("Please enter at least one subject\n");
            rightInput = false;
        }
        //Todo: how to show calendar to pick a date?
        if (date.isEmpty()) {
            warningText.append("When did you write this story?\n");
            rightInput = false;
        }
        if (summary.isEmpty()) {
            warningText.append("Please give st least one line to tell what this story is about\n");
            rightInput = false;
        }
        if (content.isEmpty()) {
            warningText.append("Don't forget to add the story\n");
            rightInput = false;
        }
        if (!rightInput) {
            Alert errorMessage = new Alert(Alert.AlertType.ERROR);
            errorMessage.setContentText(warningText.toString());
            errorMessage.show();
            story = null;
        } else {
            story = new Story(title, subtitle, subject, date, summary, content, userDAO.getOneByUsername(storyteller.getUserName()));
        }
    }
}


