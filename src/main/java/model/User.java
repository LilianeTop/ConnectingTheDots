package model;

import database.DBAccess;
import database.UserDAO;
import main.Main;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class User {
    public static DBAccess dbAccess = Main.getDBAccess();
    public static UserDAO userDAO = new UserDAO(dbAccess);

    private String firstName;
    private String prefix;
    private String lastName;
    private String emailaddress;
    private String role;
    public static List<String> roles = Arrays.asList("storyteller", "reader", "commenter", "admin");
    private UsernameGenerator userNameCreator;//username is unique and auto generated
    private PasswordGenerator passwordCreator;//autogenerated
    private String userName;
    private String password;

    public User(String firstName, String prefix, String lastName, String emailaddress, String role, String userName, String password) {
        super();
        this.firstName = firstName;
        this.prefix = prefix;
        this.lastName = lastName;
        this.emailaddress = emailaddress;
        this.role = role;
        this.userNameCreator = new UsernameGenerator(firstName, lastName);//todo automatically generate a username
        this.passwordCreator = new PasswordGenerator(new PasswordGenerator.PasswordGeneratorBuilder());
        this.userName = userNameCreator.createUsername();
        this.password = passwordCreator.generate(10);
    }

    //constructor to register this constructor calls next cinstructor and then a username and password will be created.
    public User(String firstName, String prefix, String lastName, String emailaddress, String role) {
        this(firstName, prefix, lastName, emailaddress, role, null, null);
        /*this.userNameCreator = new UsernameGenerator(firstName, lastName);//todo automatically generate a username
        this.passwordCreator = new PasswordGenerator(new PasswordGenerator.PasswordGeneratorBuilder());
        this.userName = userNameCreator.createUsername();
        this.password = passwordCreator.generate(10);*/
    }


    public String getUserName() {
        return String.valueOf(userName);
    }

    public String getPassword() {
        return String.valueOf(password);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static List<String> getRoles() {
        return roles;
    }

    public static void setRoles(List<String> roles) {
        User.roles = roles;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return emailaddress.equals(user.emailaddress) &&
                userName.equals(user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailaddress, userName);
    }

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder("");
        resultString.append(firstName + " ");
        if (prefix != null) {
            resultString.append(prefix + " ");
        }
        resultString.append(lastName + " ");
        resultString.append("( " + role + " )");
        return resultString.toString();
    }
}
