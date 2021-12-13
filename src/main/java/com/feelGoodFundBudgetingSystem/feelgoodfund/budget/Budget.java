package com.feelGoodFundBudgetingSystem.feelgoodfund.budget;

import com.google.cloud.Timestamp;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Budget {
    private String amount;
    private String username;
    private String id;
    private String date;
    private String time;

    public Budget() {

    }

    public Budget(String amount) {
        this.amount = amount;
    }

    public Budget(String amount, String username) {
        this.amount = amount;
        this.username = username;
    }

    public Budget(String amount, String username, String id, String date, String time) {
        this.amount = amount;
        this.username = username;
        this.id = id;
        this.date = date;
        this.time = time;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
