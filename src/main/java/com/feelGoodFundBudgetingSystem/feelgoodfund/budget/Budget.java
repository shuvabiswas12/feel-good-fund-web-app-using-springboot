package com.feelGoodFundBudgetingSystem.feelgoodfund.budget;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Budget {
    private double amount;
    private String username;
    private int id;
    private String date;
    private String time;

    public Budget() {

    }

    public Budget(double amount) {
        this.amount = amount;
    }

    public Budget(double amount, String username) {
        this.amount = amount;
        this.username = username;
    }

    public Budget(double amount, String username, int id, String date, String time) {
        this.amount = amount;
        this.username = username;
        this.id = id;
        this.date = date;
        this.time = time;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        if (date.isEmpty()) {

        }
        this.date = date;

    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        if (time.isEmpty()) {

        }
        this.time = time;
    }

    @Override
    public String toString() {
        return "Budget{" +
                "amount=" + amount +
                ", username='" + username + '\'' +
                ", id=" + id +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
