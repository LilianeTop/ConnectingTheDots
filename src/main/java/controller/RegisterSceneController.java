package controller;

import database.DBAccess;
import database.UserDAO;
import javafx.event.ActionEvent;
import main.Main;

public class RegisterSceneController {
    private UserDAO userDAO;
    private DBAccess dbAccess;

    public void doRegister(ActionEvent actionEvent) {
        //TODO create a new user with automatically created username and password
        //todo send automatically a welcome email to user with username and password
        //todo store in db
        //userDAO.storeOne();
    }

    public void doLoginScene(ActionEvent actionEvent) {
        Main.getSceneManager().showLoginScene();
    }
}
