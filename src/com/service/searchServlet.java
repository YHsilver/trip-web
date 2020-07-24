package com.service;

import com.alibaba.fastjson.JSONArray;
import com.dao.TravelimageDAO;
import com.dao.TraveluserDAO;
import com.entity.Travelimage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "searchServlet", urlPatterns = "/searchServlet")
public class searchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txt = request.getParameter("searchTxt");
        String field = request.getParameter("field");
        String order = request.getParameter("order");
        String startIndex = request.getParameter("startIndex");

        if (txt==null)
            txt="";

        TravelimageDAO dao = new TravelimageDAO();

        long totalNum;

        List<Travelimage> imgs;
        if ("title".equals(field)) {
            totalNum = dao.getCountWithTitle("%" + txt + "%");
            if ("hot".equals(order)) {
                imgs = dao.getForPageInTitleByHot("%" + txt + "%", Integer.parseInt(startIndex), 6);
            } else {
                imgs = dao.getForPageInTitleByTime("%" + txt + "%", Integer.parseInt(startIndex), 6);
            }
        } else {
            totalNum = dao.getCountWithTheme("%" + txt + "%");
            if ("hot".equals(order)) {
                imgs = dao.getForPageInThemeByHot("%" + txt + "%", Integer.parseInt(startIndex), 6);
            } else {
                imgs = dao.getForPageInThemeByTime("%" + txt + "%", Integer.parseInt(startIndex), 6);
            }
        }

        TraveluserDAO udao = new TraveluserDAO();

        for (Travelimage travelimage : imgs) {
            travelimage.setUserName(udao.get(travelimage.getUid()).getUserName());
        }

        request.getSession().setAttribute("results",imgs);
        response.getWriter().println("{\"totalNum\": " + totalNum + "}");

    }
}
