package com.ipl.test;

import java.util.ArrayList;

import com.ipl.dao.PlayerDAO;
import com.ipl.model.Player;

public class TestPlayerDAO {

    public static void main(String[] args) {

        PlayerDAO dao = new PlayerDAO();

        ArrayList<Player> playerList = dao.getAllPlayers();

        for (Player player : playerList) {

            System.out.println("Player ID : " + player.getPlayerId());
            System.out.println("Player Name : " + player.getPlayerName());
            System.out.println("Role : " + player.getRole());
            System.out.println("Team ID : " + player.getTeamId());

            System.out.println("------------------------");
        }
    }
    
}