package com.service;


import com.dao.RoomDAO;
import com.entity.Room;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "sendChattingMessageServlet" ,urlPatterns = "/sendChattingMessageServlet")
public class SendChattingMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginUsername = (String) request.getSession().getAttribute("username");
        if(loginUsername == null){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().print("{\"message\":\"Please log in first!\"}");
            return;
        }

        String user1 = request.getParameter("user1");
        String user2 = request.getParameter("user2");
        RoomDAO rdao=new RoomDAO();
        Room room =rdao.findRoom(user1, user2);

        if(!user1.equals(loginUsername) && !user2.equals(loginUsername)){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().print("{\"message\":\"No authority!\"}");
            return;
        }

        if(room == null){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().print("{\"message\":\"No such chatting room!\"}");
            return;
        }

        String message = request.getParameter("message");
        if(message == null || message.equals("")){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().print("{\"message\":\"Empty message!\"}");
            return;
        }

        room.setMessages(room.getMessages() + loginUsername + ": " + message + "\n");
        room.setLastModified(new Date().getTime());
        rdao.save(room);
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().print("{\"message\":\"Message Send Success!\"}");

    }
}
