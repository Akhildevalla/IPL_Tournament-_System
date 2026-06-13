package com.ipl.test;

import com.ipl.dao.PlayerDAO;
import com.ipl.model.Player;

public class TestUpdatePlayer {

    public static void main(String[] args) {

        Player player = new Player();

        player.setPlayerId(18);
        player.setPlayerName("King Kohli");
        player.setRole("Captain");
        player.setTeamId(3);

        PlayerDAO dao = new PlayerDAO();

        boolean status = dao.updatePlayer(player);

        if(status) {
            System.out.println("Player Updated Successfully!");
        } else {
            System.out.println("Failed to Update Player!");
        }
    }
}