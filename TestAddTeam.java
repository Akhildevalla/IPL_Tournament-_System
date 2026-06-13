package com.ipl.test;

import com.ipl.dao.TeamDAO;
import com.ipl.model.Team;

public class TestAddTeam {

    public static void main(String[] args) {

        Team team = new Team();

        team.setTeamName("Sunrisers Hyderabad");
        team.setShortName("SRH");

        TeamDAO dao = new TeamDAO();

        boolean status = dao.addTeam(team);

        if(status) {
            System.out.println("Team Added Successfully!");
        } else {
            System.out.println("Failed to Add Team!");
        }
    }
}