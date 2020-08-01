package controller;

import database.DBAccess;
import database.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import main.Main;
import model.EmailValidator;
import model.EmailWithLoginDetails;
import model.User;

public class RegisterSceneController {
    private UserDAO userDAO;
    private DBAccess dbAccess;
    private User user;
    private String role = "reader";
    EmailWithLoginDetails email;


    @FXML
    private Label titleApplicationLabel;

    @FXML
    private Label titleRegisterSceneLabel;

    @FXML
    private TextField firstNameTextfield;

    @FXML
    private TextField prefixTextfield;

    @FXML
    private TextField lastNameTextfield;

    @FXML
    private TextField emailaddressTextfield;

    @FXML
    private  ToggleGroup toggleGroup;

    @FXML
    private RadioButton readerRadioButton;

    @FXML
    private RadioButton commenterRadioButton;

    @FXML
    private RadioButton storytellerRadioButton;

    @FXML
    private void initialize(){

        readerRadioButton.setSelected(true);
    }

    public RegisterSceneController() {
        super();
        this.dbAccess = Main.getDBAccess();
        this.userDAO = new UserDAO(dbAccess);
    }

    @FXML
    public void doRegister(ActionEvent actionEvent) {
        //todo send automatically a welcome email to user with username and password
        createUser();
        StringBuilder warningText = new StringBuilder();
        if (userDAO.getOneByEmailaddress(emailaddressTextfield.getText()) != null) {
            warningText.append("Please log in. This email address is already connected to an account.");
            Alert errorMessage = new Alert(Alert.AlertType.ERROR);
            errorMessage.setContentText(warningText.toString());
            errorMessage.show();
            user = null;
        } else {
            userDAO.storeOne(user);
            Alert registered = new Alert(Alert.AlertType.INFORMATION);
            registered.setContentText("You are succesfully registered. Please check your inbox for login details");
            registered.show();
            new EmailWithLoginDetails().sendConfirmationEmail();
        }
    }

    private void createUser() {
        StringBuilder warningText = new StringBuilder();
        EmailValidator emailValidator = new EmailValidator();
        boolean rightInput = true;
        String firstName = firstNameTextfield.getText().replaceAll("\\s", "");//Fixme: delete spaces in string
        String prefix = prefixTextfield.getText();
        String lastName = lastNameTextfield.getText().replaceAll("\\s", "");//Fixme: delete spaces in string
        String emailaddress = emailaddressTextfield.getText();
        //Fixme: how to access radiobuttons? Create 3 times onAction to setRole() is this the right way to do it?
        if (firstName.isEmpty()) {
            warningText.append("Please enter your first name\n");
            rightInput = false;
        }
        if (lastName.isEmpty()) {
            warningText.append("Please enter your last name\n");
            rightInput = false;
        }
        if (!emailValidator.isValid(emailaddress)) {
            warningText.append("Please enter a valid email address\n");
            rightInput = false;
            //fixme: how to check if it is an email address? regex?
        }
        if (!rightInput) {
            Alert errorMessage = new Alert(Alert.AlertType.ERROR);
            errorMessage.setContentText(warningText.toString());
            errorMessage.show();
            user = null;
        } else {
            user = new User(firstName, prefix, lastName, emailaddress, role);
        }
    }

    public void doLoginScene(ActionEvent actionEvent) {
        Main.getSceneManager().showLoginScene();
    }


    public void setRoleToReader(ActionEvent actionEvent) {
        setRole("reader");
    }

    public void setRoleToCommenter(ActionEvent actionEvent) {
        setRole("commenter");
    }

    public void setRoleToStoryTeller(ActionEvent actionEvent) {
        setRole("storyteller");
    }

    public void setRole(String role) {
        this.role = role;
    }
}
