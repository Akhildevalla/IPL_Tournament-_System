package com.ipl.model;

public class Team {

    private int teamId;
    private String teamName;
    private String shortName;

    public Team() {
    }

    public Team(int teamId, String teamName, String shortName) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.shortName = shortName;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}