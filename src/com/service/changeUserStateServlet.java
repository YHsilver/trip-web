package com.service;

import com.dao.TraveluserDAO;
import com.entity.Traveluser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "changeUserStateServlet" , urlPatterns = "/changeUserStateServlet")
public class changeUserStateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String state = request.getParameter("state");
        String username = (String) request.getSession().getAttribute("username");
        if (state==null||(!state.equals("0")&&!state.equals("1"))||username==null){
            response.getWriter().println("{\"message\": \"failed\"}");
            return;
        }

        TraveluserDAO udao=new TraveluserDAO();
        Traveluser  user= udao.getByName(username);
        if (user==null){
            response.getWriter().println("{\"message\": \"failed\"}");
            return;
        }

        if (state.equals("0")){
            user.setState(0);
        }else{
            user.setState(1);
        }
        udao.update(user);






    }

}
