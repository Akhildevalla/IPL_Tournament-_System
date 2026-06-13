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

@WebServlet("/viewPlayers")
public class ViewPlayerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        PlayerDAO dao = new PlayerDAO();

        ArrayList<Player> players = dao.getAllPlayers();

        out.println("<html><head>");

        out.println("<style>");
        out.println("body{font-family:Segoe UI,sans-serif;background:#f4f6f9;}");
        out.println("h1,h2{text-align:center;color:#2c3e50;}");
        out.println("table{margin:auto;border-collapse:collapse;width:70%;background:white;}");
        out.println("th{background:#3498db;color:white;padding:12px;}");
        out.println("td{padding:10px;text-align:center;}");
        out.println("tr:nth-child(even){background:#f2f2f2;}");
        out.println("</style>");

        out.println("</head><body>");

        out.println("<h1>IPL Tournament Management System</h1>");
        out.println("<h2>IPL Players</h2>");

        out.println("<table>");

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