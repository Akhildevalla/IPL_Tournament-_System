package com.ipl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipl.dao.PlayerDAO;
import com.ipl.model.Player;

@WebServlet("/Players")
public class PlayerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        PlayerDAO dao = new PlayerDAO();

        ArrayList<Player> players = dao.getAllPlayers();

        out.println("<html><body>");
        out.println("<h1>IPL Players</h1>");

        out.println("<table border='1' cellpadding='10'>");
        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Name</th>");
        out.println("<th>Role</th>");
        out.println("<th>Team ID</th>");
        out.println("</tr>");

        for(Player player : players){

            out.println("<tr>");
            out.println("<td>" + player.getPlayerId() + "</td>");
            out.println("<td>" + player.getPlayerName() + "</td>");
            out.println("<td>" + player.getRole() + "</td>");
            out.println("<td>" + player.getTeamId() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body></html>");
    }
}