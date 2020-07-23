package com.service;

import com.dao.TravelimagefavorDAO;
import com.dao.TraveluserDAO;
import com.entity.Travelimagefavor;
import com.entity.Traveluser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addFavorServlet", urlPatterns = "/addFavorServlet")
public class addFavorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String imgId = request.getParameter("imageId");


        TraveluserDAO udao = new TraveluserDAO();
        Traveluser user = udao.getByName(username);

        if (username == null || imgId == null || user == null) {
            System.out.println("username:"+username);
            response.getWriter().println("{\"message\": \"Add Failed, please refresh page and try again later!\"}");
            return;
        }

        TravelimagefavorDAO fdao = new TravelimagefavorDAO();

        if (fdao.getValue(user.getUid()+"",imgId)>0){
            response.getWriter().println("{\"message\": \"You Have added to your favor, don't click too much \"}");
            return;
        }


        Travelimagefavor favor = new Travelimagefavor(user.getUid(), Integer.parseInt(imgId));

        fdao.save(favor);

        response.getWriter().println("{\"message\": \"success\"}");
    }
}
