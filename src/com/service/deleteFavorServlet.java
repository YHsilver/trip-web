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

@WebServlet(name = "deleteFavorServlet", urlPatterns = "/deleteFavorServlet")
public class deleteFavorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = (String) request.getSession().getAttribute("username");
        if (username == null || username.equals("")) {
            response.getWriter().println("{\"message\": \"not_exist\"}");
            return;
        }

        TraveluserDAO udao = new TraveluserDAO();
        Traveluser user = udao.getByName(username);

        String iid = request.getParameter("imageId");

        TravelimagefavorDAO fdao = new TravelimagefavorDAO();

        Travelimagefavor favor = fdao.getByImageIdAndUid(Integer.parseInt(iid), user.getUid());
        if (favor == null) {
            response.getWriter().println("{\"message\": \"favor_not_exist\"}");
            return;
        }

        int fid = favor.getFavorId();
        fdao.delete(fid);

        response.getWriter().println("{\"message\": \"success\"}");
    }
}
