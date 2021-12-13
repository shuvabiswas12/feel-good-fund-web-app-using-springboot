package com.feelGoodFundBudgetingSystem.feelgoodfund.budget;

public class Budget {
    private String amount;
    private String username;
    private String date;
    private String time;
    private String teamName;
    private String description;

    public Budget() {

    }

    public Budget(String amount) {
        this.amount = amount;
    }

    public Budget(String amount, String username) {
        this.amount = amount;
        this.username = username;
    }

    public Budget(String amount, String username, String date, String time) {
        this.amount = amount;
        this.username = username;
        this.date = date;
        this.time = time;
    }

    public Budget(String amount, String username, String date, String time, String teamName) {
        this.amount = amount;
        this.username = username;
        this.date = date;
        this.time = time;
        this.teamName = teamName;
    }

    public Budget(String amount, String username, String date, String time, String teamName, String description) {
        this.amount = amount;
        this.username = username;
        this.date = date;
        this.time = time;
        this.teamName = teamName;
        this.description = description;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Budget{" +
                "amount='" + amount + '\'' +
                ", username='" + username + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", teamName='" + teamName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

