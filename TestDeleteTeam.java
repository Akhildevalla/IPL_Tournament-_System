package com.ipl.test;

import com.ipl.dao.TeamDAO;

public class TestDeleteTeam {

    public static void main(String[] args) {

        TeamDAO dao = new TeamDAO();

        boolean status = dao.deleteTeam(5);

        if(status) {
            System.out.println("Team Deleted Successfully!");
        } else {
            System.out.println("Failed to Delete Team!");
        }
    }
}