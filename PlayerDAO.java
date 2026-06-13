package com.ipl.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.ipl.model.Player;
import com.ipl.util.DBConnection;

public class PlayerDAO {
	public ArrayList<Player> getAllPlayers() {

	    ArrayList<Player> playerList = new ArrayList<>();

	    try {

	        Connection con = DBConnection.getConnection();

	        Statement stmt = con.createStatement();

	        ResultSet rs = stmt.executeQuery("SELECT * FROM players");

	        while (rs.next()) {

	            int playerId = rs.getInt("player_id");
	            String playerName = rs.getString("player_name");
	            String role = rs.getString("role");
	            int teamId = rs.getInt("team_id");

	            Player player = new Player(
	                    playerId,
	                    playerName,
	                    role,
	                    teamId);

	            playerList.add(player);
	        }

	        con.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return playerList;
	}
	public boolean addPlayer(Player player) {

	    boolean status = false;

	    try {

	        Connection con = DBConnection.getConnection();

	        String query =
	        "INSERT INTO players(player_id, player_name, role, team_id) VALUES (?, ?, ?, ?)";

	        PreparedStatement ps =
	        con.prepareStatement(query);

	        ps.setInt(1, player.getPlayerId());
	        ps.setString(2, player.getPlayerName());
	        ps.setString(3, player.getRole());
	        ps.setInt(4, player.getTeamId());

	        int rows = ps.executeUpdate();

	        if(rows > 0) {
	            status = true;
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return status;
	}
	public boolean updatePlayer(Player player) {

	    boolean status = false;

	    try {

	        Connection con = DBConnection.getConnection();

	        String query =
	        "UPDATE players SET player_name=?, role=?, team_id=? WHERE player_id=?";

	        PreparedStatement ps =
	        con.prepareStatement(query);

	        ps.setString(1, player.getPlayerName());
	        ps.setString(2, player.getRole());
	        ps.setInt(3, player.getTeamId());
	        ps.setInt(4, player.getPlayerId());

	        int rows = ps.executeUpdate();

	        if(rows > 0) {
	            status = true;
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return status;
	}
	public boolean deletePlayer(int playerId) {

	    boolean status = false;

	    try {

	        Connection con = DBConnection.getConnection();

	        String query =
	        "DELETE FROM players WHERE player_id=?";

	        PreparedStatement ps =
	        con.prepareStatement(query);

	        ps.setInt(1, playerId);

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