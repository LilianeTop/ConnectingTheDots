package model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class User {
    private String firstName;
    private String prefix;
    private String lastName;
    private String emailaddress;
    private String role;
    public static List<String> roles = Arrays.asList("storyteller", "reader", "commenter", "admin");
    private String userName;
    private String password;

    //all-args constructor
    public User(String firstName, String prefix, String lastName, String emailaddress, String role, String userName, String password) {
        super();
       this.firstName = firstName;
        this.prefix = prefix;
        this.lastName = lastName;
        this.emailaddress = emailaddress;
        this.role = role;
        this.userName = userName;
        this.password = password;
    }

    //constructor to be used when registering otherwise the all-args constructor needs to be used to prevent from renewing username and password
    public User(String firstName, String prefix, String lastName, String emailaddress, String role) {
        this(firstName , prefix, lastName, emailaddress, role, new UsernameGenerator().createUsername(firstName, lastName), new PasswordGenerator(new PasswordGenerator.PasswordGeneratorBuilder()).generate(10));

    }


    public String getUserName() {
        return String.valueOf(userName);
    }

    public String getPassword() {
        return String.valueOf(password);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getLastName() {
        return lastName;
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

    //TODO: get explained again why this is neccessarry
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
        resultString.append("(" + role + ")");
        return resultString.toString();
    }
}
