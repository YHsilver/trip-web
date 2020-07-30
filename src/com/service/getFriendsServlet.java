package com.service;

import com.dao.InvitationDAO;
import com.dao.TraveluserDAO;
import com.entity.Invitation;
import com.entity.Traveluser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "getFriendsServlet", urlPatterns = "/getFriendsServlet")
public class getFriendsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        TraveluserDAO udao = new TraveluserDAO();
        List<Traveluser> users = udao.getContainName(username);
        request.getSession().setAttribute("users", users);
        response.getWriter().println("{\"message\": \"success\"}");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");


        if (username == null || username.equals("")) {
            response.sendRedirect("index.jsp");
            return;
        }

        TraveluserDAO udao = new TraveluserDAO();
        Traveluser user = udao.getByName(username);


        request.getSession().setAttribute("userState", user.getState() == 1);


        //getFriends list
        String friendsUidsStr = user.getFriendsUid();
        List<Traveluser> friends = new ArrayList<>();
        if (friendsUidsStr != null) {
            String[] friendsUids = friendsUidsStr.split(",");
            for (String fid : friendsUids) {
                friends.add(udao.get(Integer.parseInt(fid)));
            }
        }


        request.getSession().setAttribute("friends", friends);

        InvitationDAO ivdao = new InvitationDAO();
        List<Invitation> invitations = ivdao.getByReceiverUidAndState(user.getUid(), 0);


        for (Invitation iv : invitations) {
            Traveluser sender = udao.get(iv.getSenderUid());
            iv.setSenderName(sender.getUserName());
            iv.setSenderEmail(sender.getEmail());
        }


        request.getSession().setAttribute("myInvitation", invitations);
        response.getWriter().println("{\"message\": \"success\"}");
        request.getRequestDispatcher("friends.jsp").forward(request,response);
    }
}
