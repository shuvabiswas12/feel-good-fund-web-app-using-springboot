package com.feelGoodFundBudgetingSystem.feelgoodfund.budget;

public class Budget {
    private String amount;
    private String username;
    private String date;
    private String time;
    private String teamName;

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

    @Override
    public String toString() {
        return "Budget{" +
                "amount='" + amount + '\'' +
                ", username='" + username + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", teamName='" + teamName + '\'' +
                '}';
    }
}

