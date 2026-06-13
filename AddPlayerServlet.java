package com.ipl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipl.dao.PlayerDAO;
import com.ipl.model.Player;

@WebServlet("/addPlayer")
public class AddPlayerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int playerId =
            Integer.parseInt(request.getParameter("playerId"));

        String playerName =
            request.getParameter("playerName");

        String role =
            request.getParameter("role");

        int teamId =
            Integer.parseInt(request.getParameter("teamId"));

        Player player =
            new Player(playerId, playerName, role, teamId);

        PlayerDAO dao = new PlayerDAO();

        boolean status = dao.addPlayer(player);

        if(status) {
            response.getWriter().println("Player Added Successfully!");
        } else {
            response.getWriter().println("Player Not Added!");
        }
    }
}