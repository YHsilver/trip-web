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

@WebServlet(name = "addFriendServlet", urlPatterns = "/addFriendServlet")
public class addFriendServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        String friendUid = request.getParameter("uid");


        if (username == null || username.equals("")) {
            response.sendRedirect("index.jsp");
            return;
        }

        if (friendUid == null||friendUid.equals("")){
            response.getWriter().println("{\"message\": \"failed\"}");
            return;
        }

        TraveluserDAO udao = new TraveluserDAO();
        Traveluser user = udao.getByName(username);
        Traveluser friend = udao.get(Integer.parseInt(friendUid));

        if (friend==null){
            response.getWriter().println("{\"message\": \"user not exist\"}");
            return;
        }


        InvitationDAO ivdao = new InvitationDAO();

        if (ivdao.getBySenderAndReceiver(user.getUid(),friend.getUid()).size()>0
                ||ivdao.getBySenderAndReceiver(friend.getUid(),user.getUid()).size()>0){
            response.getWriter().println("{\"message\": \"You have invited\"}");
            return;
        }


        Invitation invitation = new Invitation(user.getUid(),friend.getUid(),0);

        ivdao.save(invitation);

        response.getWriter().println("{\"message\":\"success\"}");

    }
}
