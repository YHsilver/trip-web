package com.service;

import com.dao.TravelimageDAO;
import com.dao.TraveluserDAO;
import com.entity.Travelimage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "indexPageServlet",urlPatterns = "/indexPageServlet")
public class indexPageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TravelimageDAO dao = new TravelimageDAO();
        List<Travelimage> hotest = dao.getForPageByHot(0,5);

        TraveluserDAO udao=new TraveluserDAO();

        for (Travelimage travelimage: hotest){
            travelimage.setUserName(udao.get(travelimage.getUid()).getUserName());
        }

        request.getSession().setAttribute("hot_pic",hotest);
        List<Travelimage> newest = dao.getForPageByTime(0,3);

        for (Travelimage travelimage: newest){
            travelimage.setUserName(udao.get(travelimage.getUid()).getUserName());
        }

        request.getSession().setAttribute("new_pic",newest);

        response.sendRedirect("index.jsp");
    }
}
