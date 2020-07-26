package com.service;


import com.dao.GeocitiesDAO;
import com.dao.GeocountriesRegionsDAO;
import com.dao.TravelimageDAO;
import com.dao.TraveluserDAO;
import com.entity.Geocities;
import com.entity.GeocountriesRegions;
import com.entity.Travelimage;
import com.entity.Traveluser;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "modifyPictureServlet", urlPatterns = "/modifyPictureServlet")
@MultipartConfig
public class modifyPictureServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = (String) request.getSession().getAttribute("username");
        if (username == null || username.equals("")) {
            response.getWriter().println("{\"message\": \"user_not_exist\"}");
            return;
        }

        TraveluserDAO udao = new TraveluserDAO();
        Traveluser user = udao.getByName(username);

        if (user == null) {
            response.getWriter().println("{\"message\": \"user_not_exist\"}");
            return;
        }

        String imageId = request.getParameter("imageId");
        String title = request.getParameter("title");
        String theme = request.getParameter("theme");
        String country = request.getParameter("country");
        String city = request.getParameter("city");
        String description = request.getParameter("description");

        String filearg = request.getParameter("file");


        Part part = request.getPart("file");


        GeocountriesRegionsDAO rdao = new GeocountriesRegionsDAO();

        GeocountriesRegions region = rdao.getByName(country);


        if (region == null) {
            System.out.println(country);
            response.getWriter().println("{\"message\": \"region_not_exist\"}");
            return;
        }
        TravelimageDAO idao = new TravelimageDAO();
        GeocitiesDAO cdao = new GeocitiesDAO();
        Geocities geocity = cdao.getByCountryAndCityName(region.getIso(), city);
        System.out.println(geocity.getAsciiName());
        if (geocity == null) {
            response.getWriter().println("{\"message\": \"city_not_exist\"}");
            return;
        }


        Travelimage oldImg = idao.get(Integer.parseInt(imageId));

        oldImg.setTitle(title);
        oldImg.setTheme(theme);
        oldImg.setDescription(description);
        oldImg.setCountryRegionCodeIso(region.getIso());
        oldImg.setCityCode(geocity.getGeoNameId());
        oldImg.setTimeUpload(new java.sql.Date(System.currentTimeMillis()));

        if (part != null&&!"undefined".equals(filearg)) {
            String savePath = request.getServletContext().getRealPath("/static/image/travel-images");
            String fileName = "" + new Date().getTime() + ".jpg";
            part.write(savePath + File.separator + "medium" + File.separator + fileName);
            oldImg.setPath(fileName);
        }

        idao.update(oldImg);

        response.getWriter().println("{\"message\": \"Update Success!!\"}");

    }

}

