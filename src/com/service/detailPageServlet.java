package com.service;

import com.dao.GeocitiesDAO;
import com.dao.GeocountriesRegionsDAO;
import com.dao.TravelimageDAO;
import com.dao.TraveluserDAO;
import com.entity.Travelimage;
import com.entity.Traveluser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "detailPageServlet", urlPatterns = "/detailPageServlet")
public class detailPageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int imageId = Integer.parseInt(request.getParameter("imageId"));
        TravelimageDAO dao = new TravelimageDAO();
        Travelimage img = dao.get(imageId);

        TraveluserDAO udao = new TraveluserDAO();
        img.setUserName(udao.get(img.getUid()).getUserName());

        GeocountriesRegionsDAO rdao = new GeocountriesRegionsDAO();
        img.setCountry(rdao.get(img.getCountryRegionCodeIso()).getCountryRegionName());

        GeocitiesDAO cdao = new GeocitiesDAO();
        img.setCity(cdao.get(img.getCityCode()).getAsciiName());


        request.getSession().setAttribute("image", img);
        response.sendRedirect("detail.jsp");
    }
}
