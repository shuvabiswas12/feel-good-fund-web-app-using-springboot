package com.feelGoodFundBudgetingSystem.feelgoodfund.team;

public class Team {
    private String budget;
    private String teamName;

    public Team(String budget, String teamName) {
        this.budget = budget;
        this.teamName = teamName;
    }

    public Team() {

    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        return "Team{" +
                "budget='" + budget + '\'' +
                ", teamName='" + teamName + '\'' +
                '}';
    }
}


