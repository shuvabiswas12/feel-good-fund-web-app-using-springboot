package com.feelGoodFundBudgetingSystem.feelgoodfund.users;

public class Users {

    private String _id;
    private String username;
    private String email;
    private String password;
    private String teamName;

    public Users() {
    }

    // registering
    public Users(String username, String email, String password, String teamName) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.teamName = teamName;
    }

    // login
    public Users(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // get the values from database
    public Users(String _id, String username, String email, String password, String teamName) {
        this._id = _id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.teamName = teamName;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        return "Users{" +
                "_id='" + _id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", teamName='" + teamName + '\'' +
                '}';
    }
}
