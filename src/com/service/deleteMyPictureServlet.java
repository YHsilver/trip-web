package com.service;

import com.dao.TravelimageDAO;
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
import java.util.List;

@WebServlet(name = "deleteMyPictureServlet", urlPatterns = "/deleteMyPictureServlet")
public class deleteMyPictureServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = (String) request.getSession().getAttribute("username");
        if (username == null || username.equals("")) {
            response.getWriter().println("{\"message\": \"not_exist\"}");
            return;
        }

        String iid = request.getParameter("imageId");

        TravelimagefavorDAO fdao = new TravelimagefavorDAO();

        List<Travelimagefavor> favors = fdao.getByImageId(Integer.parseInt(iid));

        for (Travelimagefavor favor : favors) {
            fdao.delete(favor.getFavorId());

        }

        TravelimageDAO idao = new TravelimageDAO();
        idao.delete(Integer.parseInt(iid));

        response.getWriter().println("{\"message\": \"success\"}");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
