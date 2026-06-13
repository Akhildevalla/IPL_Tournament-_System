package com.ipl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipl.dao.TeamDAO;
import com.ipl.model.Team;

@WebServlet("/viewTeams")
public class TeamServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        TeamDAO dao = new TeamDAO();

        ArrayList<Team> teamList = dao.getAllTeams();

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
        out.println("<h2>IPL Teams</h2>");

        out.println("<table>");
        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Team Name</th>");
        out.println("<th>Short Name</th>");
        out.println("</tr>");

        for(Team team : teamList){

            out.println("<tr>");
            out.println("<td>" + team.getTeamId() + "</td>");
            out.println("<td>" + team.getTeamName() + "</td>");
            out.println("<td>" + team.getShortName() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body></html>");
    }
}