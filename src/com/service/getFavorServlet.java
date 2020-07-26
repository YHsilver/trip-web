package com.service;

import com.alibaba.fastjson.JSONArray;
import com.dao.TravelimageDAO;
import com.dao.TravelimagefavorDAO;
import com.dao.TraveluserDAO;
import com.entity.Travelimage;
import com.entity.Travelimagefavor;
import com.entity.Traveluser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "getFavorServlet", urlPatterns = "/getFavorServlet")
public class getFavorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String startIndex = request.getParameter("startIndex");
        doRequest(request, response, Integer.parseInt(startIndex),2);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doRequest(request, response, 0,1);

    }

    private void doRequest(HttpServletRequest request, HttpServletResponse response, int startIndex, int type) throws IOException {
        String username = (String) request.getSession().getAttribute("username");
        if (username == null || username.equals("")) {
            response.sendRedirect("index.jsp");
            return;
        }

        TraveluserDAO udao = new TraveluserDAO();
        Traveluser user = udao.getByName(username);

        TravelimagefavorDAO fdao = new TravelimagefavorDAO();

        List<Travelimagefavor> favors = fdao.getPartByUid(user.getUid(), startIndex, 3);


        List<Travelimage> favorImgs = new ArrayList<>();

        TravelimageDAO idao = new TravelimageDAO();

        for (Travelimagefavor favor : favors) {
            favorImgs.add(idao.get(favor.getImageId()));
        }

        for (Travelimage img : favorImgs) {
            img.setUserName(udao.get(img.getUid()).getUserName());
        }


        request.getSession().setAttribute("favor", favorImgs);

        if (type==1){
            response.sendRedirect("favor.jsp");

        }else if (type==2){
            long totalNum = fdao.getCountByUid(user.getUid());
            response.getWriter().println("{\"totalNum\":" + totalNum + "}");
        }




        List<Travelimage> historyImg =new ArrayList<>();

        String historyImgIdStr= user.getHistoryImageId();

        if (historyImgIdStr!=null) {
            String[] historyImgId = historyImgIdStr.split(",");

            for (String iid : historyImgId) {
                historyImg.add(idao.get(Integer.parseInt(iid)));
            }

            Collections.reverse(historyImg);
            request.getSession().setAttribute("history", historyImg);

        }

    }
}
