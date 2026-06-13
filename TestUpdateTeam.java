package com.ipl.test;

import com.ipl.dao.TeamDAO;
import com.ipl.model.Team;

public class TestUpdateTeam {

    public static void main(String[] args) {

        Team team = new Team();

        team.setTeamId(5);
        team.setTeamName("Sunrisers Hyderabad Official");
        team.setShortName("SRH");

        TeamDAO dao = new TeamDAO();

        boolean status = dao.updateTeam(team);

        if(status) {
            System.out.println("Team Updated Successfully!");
        } else {
            System.out.println("Failed to Update Team!");
        }
    }
}