package com.service;

import com.alibaba.fastjson.JSONArray;
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
import java.util.List;


@WebServlet(name = "uploadServlet", urlPatterns = "/uploadServlet")
@MultipartConfig
public class uploadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = (String) req.getSession().getAttribute("username");
        if (username == null || username.equals("")) {
            resp.sendRedirect("index.jsp");
            return;
        }

        String iid = req.getParameter("imageId");
        GeocountriesRegionsDAO countryDao = new GeocountriesRegionsDAO();
        List<GeocountriesRegions> countries = countryDao.getAll();
        req.setAttribute("countries", countries);

        if (iid != null && !iid.equals("")) {
            TravelimageDAO idao = new TravelimageDAO();
            Travelimage img = idao.get(Integer.parseInt(iid));


            GeocitiesDAO cityDao = new GeocitiesDAO();


            GeocountriesRegions country = countryDao.get(img.getCountryRegionCodeIso());
            img.setCountry(country.getCountryRegionName());
            img.setCity(cityDao.get(img.getCityCode()).getAsciiName());

            List<Geocities> cities = cityDao.getByRegion(country.getIso());

            req.setAttribute("cities", cities);
            req.setAttribute("myLoad", img);
        }


        req.getRequestDispatcher("/upload.jsp").forward(req,resp);

    }

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

        String title = request.getParameter("title");
        String theme = request.getParameter("theme");
        String country = request.getParameter("country");
        String city = request.getParameter("city");
        String description = request.getParameter("description");


        String savePath = request.getServletContext().getRealPath("/static/image/travel-images");
        Part part = request.getPart("file");
        String fileName = "" + new Date().getTime() + ".jpg";
        part.write(savePath + File.separator + "medium" + File.separator + fileName);


        TravelimageDAO idao = new TravelimageDAO();

        GeocitiesDAO cdao = new GeocitiesDAO();
        GeocountriesRegionsDAO rdao = new GeocountriesRegionsDAO();
        GeocountriesRegions region = rdao.getByName(country);
        if (region == null) {
            response.getWriter().println("{\"message\": \"region_not_exist\"}");
            return;
        }
        Geocities geocity = cdao.getByCountryAndCityName(region.getIso(), city);

        if (geocity == null) {
            response.getWriter().println("{\"message\": \"city_not_exist\"}");
            return;
        }

        Travelimage img = new Travelimage(title, description, region.getIso(),
                geocity.getGeoNameId(), user.getUid(), fileName, 0, theme);

        System.out.println(JSONArray.toJSON(img));
        idao.save(img);
        response.getWriter().println("{\"message\": \"Upload Success!!\"}");

    }


}
