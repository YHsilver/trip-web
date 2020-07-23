package com.service;

import com.dao.TraveluserDAO;
import com.entity.Traveluser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet(name = "registerServlet", urlPatterns = "/registerServlet")
public class registerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        if (username==null||username.equals("") ||password==null||password.equals("") || email==null||email.equals("")) {
            response.getWriter().println("{\"message\": \"information not complete\"}\n");

        } else {
            TraveluserDAO dao = new TraveluserDAO();

            if (dao.getCountWithName(username) > 0) {
                response.getWriter().println("{\"message\": \"username already existed\"}\n");

            } else {
                Traveluser user = new Traveluser();
                user.setUserName(username);
                user.setPass(password);
                user.setEmail(email);
                user.setState(1);
                Timestamp timestamp=new Timestamp(System.currentTimeMillis());
                user.setDateJoined(timestamp);
                user.setDateLastModified(timestamp);
                dao.save(user);

                request.getSession().setAttribute("username",username);

                response.getWriter().println("{\"message\": \"success\"}\n");
            }
        }
    }
}