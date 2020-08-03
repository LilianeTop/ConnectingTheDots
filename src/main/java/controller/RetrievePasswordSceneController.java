package controller;

import database.mySQL.DBAccess;
import database.mySQL.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import main.Main;
import model.User;

public class RetrievePasswordSceneController {
    private UserDAO userDAO;
    private DBAccess dbAccess;
    private String userName;
    @FXML
    TextField emailaddressForPasswordRetrieval;

    public void doSendLink(ActionEvent actionEvent) {
        StringBuilder warningText = new StringBuilder();
        boolean correctInput = true;
        String emailaddress = emailaddressForPasswordRetrieval.getText();
        User user = userDAO.getOneByEmailaddress(emailaddress);
        if (emailaddress.isEmpty()) {
            warningText.append("Please enter an emailaddress.\n");
            correctInput = false;
        }
        //how to check if emailaddress is in db?
        if(!user.getEmailaddress().equals(emailaddress)) {
                warningText.append("This emailaddress is not linked to any existing account. Please try another emailaddress or register");
                correctInput = false;
            }
        if (!correctInput) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setContentText(warningText.toString());
            error.show();
        } else {
            Main.getSceneManager().showLinkHasBeenSent();
        }
    }

    public void doLoginScene(ActionEvent actionEvent) {
        Main.getSceneManager().showLoginScene();
    }
}
