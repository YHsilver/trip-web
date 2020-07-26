package com.service;

import com.alibaba.fastjson.JSONArray;
import com.dao.GeocitiesDAO;
import com.dao.GeocountriesRegionsDAO;
import com.entity.Geocities;
import com.entity.GeocountriesRegions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "getCitiesServlet" , urlPatterns = "/getCitiesServlet")
public class getCitiesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String countryName=request.getParameter("country");

        GeocountriesRegionsDAO countryDao = new GeocountriesRegionsDAO();

        GeocountriesRegions country = countryDao.getByName(countryName);
        if (country==null){
            response.getWriter().println("{\"message\": \"get information failed\"}");
            return;
        }

        GeocitiesDAO cityDao = new GeocitiesDAO();
        List<Geocities> geocities = cityDao.getByRegion(country.getIso());
        List<String> citiesNames = new ArrayList<>();

        for (Geocities cities: geocities){
            citiesNames.add(cities.getAsciiName());
        }

        response.getWriter().println("{\"cities\": "+ JSONArray.toJSONString(citiesNames) +"}");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
