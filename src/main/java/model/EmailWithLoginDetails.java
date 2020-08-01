package model;

public class EmailWithLoginDetails {
    private String emailaddress;
    private String userName;
    private String password;
    private StringBuilder loginMessage;

    public void sendConfirmationEmail() {
        getLoginMessage();
        getEmailaddress();
        //todo: how to send an email from a java application?

    }

    public StringBuilder createEmailContent(){
        StringBuilder loginMessage = new StringBuilder();
        getUserName();
        getPassword();
        return loginMessage;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public StringBuilder getLoginMessage() {
        return loginMessage;
    }
}
