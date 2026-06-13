package com.ipl.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.ipl.model.Team;
import com.ipl.util.DBConnection;

public class TeamDAO {
	public ArrayList<Team> getAllTeams() {

	    ArrayList<Team> teamList = new ArrayList<>();

	    try {

	        Connection con = DBConnection.getConnection();
	        System.out.println("Connection ="+ con);

	        Statement stmt = con.createStatement();

	        ResultSet rs = stmt.executeQuery("SELECT * FROM teams");

	        while (rs.next()) {

	            int teamId = rs.getInt("team_id");
	            String teamName = rs.getString("team_name");
	            String shortName = rs.getString("short_name");

	            Team team = new Team(teamId, teamName, shortName);

	            teamList.add(team);
	        }

	        con.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return teamList;
	}
	public boolean addTeam(Team team) {

	    boolean status = false;

	    try {

	        Connection con = DBConnection.getConnection();

	        String query = "INSERT INTO teams(team_name, short_name) VALUES (?, ?)";

	        PreparedStatement ps = con.prepareStatement(query);

	        ps.setString(1, team.getTeamName());
	        ps.setString(2, team.getShortName());

	        int rows = ps.executeUpdate();

	        if (rows > 0) {
	            status = true;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return status;
	}
	public boolean updateTeam(Team team) {

	    boolean status = false;

	    try {

	        Connection con = DBConnection.getConnection();

	        String query =
	        "UPDATE teams SET team_name=?, short_name=? WHERE team_id=?";

	        PreparedStatement ps =
	        con.prepareStatement(query);

	        ps.setString(1, team.getTeamName());
	        ps.setString(2, team.getShortName());
	        ps.setInt(3, team.getTeamId());

	        int rows = ps.executeUpdate();

	        if(rows > 0) {
	            status = true;
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return status;
	}
	public boolean deleteTeam(int teamId) {

	    boolean status = false;

	    try {

	        Connection con = DBConnection.getConnection();

	        String query =
	        "DELETE FROM teams WHERE team_id=?";

	        PreparedStatement ps =
	        con.prepareStatement(query);

	        ps.setInt(1, teamId);

	        int rows = ps.executeUpdate();

	        if(rows > 0) {
	            status = true;
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return status;
	}

}