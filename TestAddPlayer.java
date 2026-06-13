package com.ipl.test;

import com.ipl.dao.PlayerDAO;
import com.ipl.model.Player;

public class TestAddPlayer {

    public static void main(String[] args) {

        Player player = new Player();

        player.setPlayerId(100);
        player.setPlayerName("KL Rahul");
        player.setRole("Batsman");
        player.setTeamId(4);

        PlayerDAO dao = new PlayerDAO();

        boolean status = dao.addPlayer(player);

        if(status) {
            System.out.println("Player Added Successfully!");
        } else {
            System.out.println("Failed to Add Player!");
        }
    }
}