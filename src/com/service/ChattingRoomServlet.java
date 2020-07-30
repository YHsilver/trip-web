package com.service;

import com.dao.RoomDAO;
import com.dao.TraveluserDAO;
import com.entity.Traveluser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "chattingRoomServlet", urlPatterns = "/chattingRoomServlet")
public class ChattingRoomServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginUsername = (String) request.getSession().getAttribute("username");
        if (loginUsername == null) {
            response.sendRedirect("index.jsp");
            return;
        }
        String targetUsername = request.getParameter("targetUser");

        TraveluserDAO udao = new TraveluserDAO();
        Traveluser loginUser = udao.getByName(loginUsername);

        Traveluser targetUser = udao.getByName(targetUsername);


        String friendslist = loginUser.getFriendsUid();

        if (friendslist == null || !friendslist.contains(targetUser.getUid() + "")) {
            System.out.println(friendslist);
            System.out.println(targetUser.getUid() + "");
            response.sendRedirect("index.jsp");
            return;
        }

        RoomDAO rdao = new RoomDAO();

        request.setAttribute("room", rdao.findOrCreateRoom(loginUsername, targetUsername));
        request.getRequestDispatcher("chattingRoom.jsp").forward(request, response);
    }
}
