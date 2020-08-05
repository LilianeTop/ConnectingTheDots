package controller;

import database.mySQL.DBAccess;
import database.mySQL.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import main.Main;
import model.User;

public class LoginSceneController {
    private UserDAO userDAO;
    private DBAccess dbAccess;
    private String userName;
    private String password;
    public static String currentRole;
    public static User currentUser;
    private StringBuilder warningText = new StringBuilder();
    private boolean correctInput = true;
    private User user;
    private String userNameInput;
    private String passwordInput;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField passwordField;
    @FXML
    private Hyperlink passwordRetrievalLink;
    @FXML
    private Hyperlink registerLink;

    public LoginSceneController() {
        super();
        this.dbAccess = Main.getDBAccess();
        this.userDAO = new UserDAO(dbAccess);
    }


    public void doLogin(ActionEvent actionEvent) {
        userNameInput = nameTextField.getText();
        passwordInput = passwordField.getText();
        user = userDAO.getOneByUsername(userNameInput);
        if (user == null) {
            warningText.append("Please enter your username.\n");
            correctInput = false;
        }
        if (passwordInput.isEmpty() || user.getPassword().equals(passwordInput)) {
            warningText.append("Please enter your password.\n");
            correctInput = false;
        }
        if (!correctInput) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setContentText(warningText.toString());
            error.show();
        } else {
            currentUser = user;
            User.setCurrentUser(currentUser);
            currentRole = user.getRole();
            Main.getSceneManager().showWelcomeScene();
        }
    }




   /* public void doLogin(ActionEvent actionEvent) {
        StringBuilder warningText = new StringBuilder();
        boolean correctInput = true;
        userName = nameTextField.getText();
        password = passwordField.getText();

        if (userName == null || password == null || userName.isEmpty() || password.isEmpty()) {
            warningText.append("Some of the fields are empty, please fill them in!.\n");
            correctInput = false;
        } else {
            User user = userDAO.getOneByUsername(userName);
            if (user == null) {
                warningText.append("No user found with this username!\n");
                correctInput = false;
            } else {
                if (!user.getUserName().equals(userName)) {
                    warningText.append("Username not valid!\n");
                    correctInput = false;
                } else {
                    if (!user.getPassword().equals(password)) {
                        warningText.append("Password not valid!\n");
                        correctInput = false;
                    } else {

                        correctInput = true;
                    }
                }
            }

            if (!correctInput) {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setContentText(warningText.toString());
                error.show();
            } else {
                currentUser = user;
                User.setCurrentUser(currentUser);
                currentRole = user.getRole();
                Main.getSceneManager().showWelcomeScene();
            }
        }*/


    public void doQuit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void doRetrievePassword(ActionEvent actionEvent) {
        Main.getSceneManager().showRetrievePasswordScene();
    }

    public void doRegister(ActionEvent actionEvent) {
        Main.getSceneManager().showRegisterScene();
    }
}
