package model;

import database.mySQL.DBAccess;
import database.mySQL.UserDAO;
import main.Main;

public class UsernameGenerator {
    public static DBAccess dbAccess = Main.getDBAccess();
    public static UserDAO userDAO = new UserDAO(dbAccess);
    private String userName;

    public UsernameGenerator() {
    }

    public String createUsername(String firstName, String lastName) {
        if (lastName.length() < 3 && firstName.length() < 3) {
            userName = String.format("%s%s%s%s%03d", lastName, "x", firstName, "x", 1);
        } else if (lastName.length() < 3) {
            userName = String.format("%s%s%s%03d", lastName, "x", firstName.substring(0, 3), 1);
        } else if (firstName.length() < 3) {
            userName = String.format("%s%s%s%03d", lastName.substring(0, 3), firstName, "x", 1);
        } else {
            userName = String.format("%s%s%03d", lastName.substring(0, 3), firstName.substring(0, 3), 1);
        }
        while (userDAO.checkIfUsernameExists(userName)) {
            //removed return and now it works properly
            userName = String.format("%s%03d", userName.substring(0, 6), (Integer.parseInt(userName.substring(6)) + 1));
        }
        return userName;
    }

    public String getUserName() {
        return userName;
    }
}
