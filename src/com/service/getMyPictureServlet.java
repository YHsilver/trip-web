package com.service;

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
import java.util.List;

@WebServlet(name = "getMyPictureServlet" ,urlPatterns = "/getMyPictureServlet")
public class getMyPictureServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        int startIndex = Integer.parseInt(request.getParameter("startIndex"));
        if (username == null || username.equals("")) {
            response.sendRedirect("index.jsp");
            return;
        }
        TraveluserDAO udao = new TraveluserDAO();
        TravelimageDAO idao = new TravelimageDAO();
        Traveluser user = udao.getByName(username);
        long totalNum = idao.getCountWithUid(user.getUid());

        response.getWriter().println("{\"totalNum\": "+totalNum+"}");


        List<Travelimage> imgs = idao.getPartByUid(user.getUid(),startIndex,3);
        request.getSession().setAttribute("myPic",imgs);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = (String) request.getSession().getAttribute("username");
        if (username == null || username.equals("")) {
            response.sendRedirect("index.jsp");
            return;
        }
        TraveluserDAO udao = new TraveluserDAO();
        TravelimageDAO idao = new TravelimageDAO();
        Traveluser user = udao.getByName(username);


        List<Travelimage> imgs = idao.getPartByUid(user.getUid(),0,3);



        request.getSession().setAttribute("myPic",imgs);
        response.sendRedirect("myPicture.jsp");
    }
}
