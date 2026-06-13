package com.ipl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipl.dao.PlayerDAO;

@WebServlet("/deletePlayer")
public class DeletePlayerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int playerId =
            Integer.parseInt(request.getParameter("playerId"));

        PlayerDAO dao = new PlayerDAO();

        boolean status = dao.deletePlayer(playerId);

        if(status) {
            response.getWriter().println("Player Deleted Successfully!");
        } else {
            response.getWriter().println("Player Not Found!");
        }
    }
}