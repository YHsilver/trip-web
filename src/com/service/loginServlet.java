package com.service;

import com.dao.TraveluserDAO;
import com.entity.Traveluser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = "/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("") || password.equals("")) {
            response.getWriter().println("{\"message\": \"information not complete\"}\n");
        } else {
            TraveluserDAO dao = new TraveluserDAO();
            Traveluser user = dao.getByName(username);

            if (user == null || !user.getPass().equals(password)) {
                response.getWriter().println("{\"message\": \"user_not_exist\"}\n");
            } else {
                request.getSession().setAttribute("username",username);
                response.getWriter().println("{\"message\": \"success\"}\n");
            }
        }

    }
}
