package dev.rynwllngtn.agorasystem.model;

public class User {
    //User Data and Identification
    private boolean isActive;
    private String userCPF;
    private String userName;
    private String userBirthdate;

    //Login and Contacts
    private String userEmail;
    private String password;

    public User(String userName, String userBirthdate, String userEmail, String userCPF, String password) {
        this.isActive = true;
        this.userCPF = userCPF;
        this.userName = userName;
        this.userBirthdate = userBirthdate;
        this.userEmail = userEmail;
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getUserCPF() {
        return userCPF;
    }

    public void setUserCPF(String userCPF) {
        this.userCPF = userCPF;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserBirthdate() {
        return userBirthdate;
    }

    public void setUserBirthdate(String userBirthdate) {
        this.userBirthdate = userBirthdate;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "-----UserData----\n" +
                "Status: " + isActive +  "\n" +
                "CPF: " + userCPF +  "\n" +
                "Name: " + userName +  "\n" +
                "Birthdate: " + userBirthdate +  "\n" +
                "Email: " + userEmail +  "\n" +
                "Password: " + password +  "\n" +
                "-----------------";
    }
}
