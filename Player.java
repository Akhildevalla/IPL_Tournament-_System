package com.ipl.model;

public class Player {

    private int playerId;
    private String playerName;
    private String role;
    private int teamId;

    public Player() {
    }

    public Player(int playerId, String playerName, String role, int teamId) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.role = role;
        this.teamId = teamId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
}