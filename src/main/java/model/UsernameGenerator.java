package model;

import database.DBAccess;
import database.UserDAO;
import main.Main;

public class UsernameGenerator {
    public static DBAccess dbAccess = Main.getDBAccess();
    public static UserDAO userDAO = new UserDAO(dbAccess);

    private String firstName;
    private String lastName;
    private String userName;


    public UsernameGenerator(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        createUsername();
    }

    public String createUsername() {
        //fixme: first create a username than check if it exist in db if so add 1
        if (lastName.length() < 3) {
            this.userName = String.format("%s%s%s%03d", this.lastName, "x", this.firstName.substring(0, 3), 1);
        } else if (firstName.length() < 3) {
            this.userName = String.format("%s%s%s%03d", this.lastName.substring(0, 3), this.firstName, "x", 1);
        } else if (lastName.length() < 3 && firstName.length() < 3) {
            this.userName = String.format("%s%s%s%s%03d", this.lastName, "x", this.firstName, "x", 1);
        } else {
            this.userName = String.format("%s%s%03d", this.lastName.substring(0, 3), this.firstName.substring(0, 3), 1);
        }
        //fixme: it will give 002 but not 003 why? it should keep looping as long as the username already exists.
        while (userDAO.checkIfUsernameExists(this.userName)){
            //removed return and now it works properly
            userName = String.format("%s%03d",this.userName.substring(0, 6), (Integer.parseInt(this.userName.substring(6)) + 1));
        }
        return userName;
       }

    /*public String userNameExists(String mpUserName) {
        //fixme: check if username already exists than the username needs to be already in db
        if (userDAO.getOneByUsername(mpUserName).equals(null)) { //fixme: this is not working
            return userName = mpUserName;
            } else {
            return userName = String.format(mpUserName.substring(0, 6) + Integer.parseInt(mpUserName.substring(6)) + 1);//does this work? not yet
        }
    }*/

    public String getUserName() {
        return userName;
    }
}
