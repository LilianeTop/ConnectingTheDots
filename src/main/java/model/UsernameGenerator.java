package model;

import database.DBAccess;
import database.UserDAO;
import main.Main;

public class UsernameGenerator {
    public static DBAccess dbAccess = Main.getDBAccess();
    public static UserDAO userDAO = new UserDAO(dbAccess);

    private String firstName;
    private String prefix;
    private String lastName;
    private String userName;




    public UsernameGenerator(String firstName, String prefix, String lastName) {
        this.firstName = firstName;
        this.prefix = prefix;
        this.lastName = lastName;
        this.userName = createUsername();
    }

    public String createUsername() {

        if (lastName.length() < 3) {
            this.userName = String.format("%s%s%s%03d",this.lastName,"x",this.firstName.substring(0, 3),001);
        }
        else if (firstName.length() < 3) {
            this.userName = String.format("%s%s%s%03d", this.lastName.substring(0, 3), this.firstName, "x", 001);
        }
        else if (lastName.length() < 3 && firstName.length() < 3) {
            this.userName = String.format("%s%s%s%s%03d",this.lastName, "x", this.firstName, "x", 001);
        } else {
            this.userName = String.format("%s%s%03d", this.lastName.substring(0, 3), this.firstName.substring(0, 3), 001);
        }
        //fixme: maybe check if username already exists than the username needs to be already in db
       /* if (!userDAO.getOneByUsername(userName).equals(null)) {//if userName already exists
            this.userName =  String.format(this.userName.substring(0, 6) + Integer.parseInt(this.userName.substring(6)) + 1);//does this work? not yet
        }*/
        return userName;
    }
    public String getUserName() {
        return userName;
    }
}
