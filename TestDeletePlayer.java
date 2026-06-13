package com.ipl.test;

import com.ipl.dao.PlayerDAO;

public class TestDeletePlayer {

    public static void main(String[] args) {

        PlayerDAO dao = new PlayerDAO();

        boolean status = dao.deletePlayer(17);

        if(status) {
            System.out.println("Player Deleted Successfully!");
        } else {
            System.out.println("Failed to Delete Player!");
        }
    }
}