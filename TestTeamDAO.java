package com.ipl.test;

import java.util.ArrayList;

import com.ipl.dao.TeamDAO;
import com.ipl.model.Team;

public class TestTeamDAO {

    public static void main(String[] args) {

        TeamDAO dao = new TeamDAO();

        ArrayList<Team> teamList = dao.getAllTeams();

        for (Team team : teamList) {

            System.out.println("ID : " + team.getTeamId());
            System.out.println("Team Name : " + team.getTeamName());
            System.out.println("Short Name : " + team.getShortName());

            System.out.println("-------------------");
        }
    }
}