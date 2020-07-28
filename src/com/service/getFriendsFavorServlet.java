package com.service;

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
import java.util.List;

@WebServlet(name = "getFriendsFavorServlet" , urlPatterns = "/getFriendsFavorServlet")
public class getFriendsFavorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int startIndex = Integer.parseInt(request.getParameter("startIndex"));

        Traveluser friend = (Traveluser) request.getSession().getAttribute("friend");

        if (friend==null){
            response.sendRedirect("/friends.jsp");
            return;
        }

        TravelimagefavorDAO fdao =  new TravelimagefavorDAO();

        List<Travelimagefavor> favors = fdao.getPartByUid(friend.getUid(),startIndex,3);
        List<Travelimage> favorImgs = new ArrayList<>();


        TravelimageDAO idao = new TravelimageDAO();

        for (Travelimagefavor favor : favors) {
            favorImgs.add(idao.get(favor.getImageId()));
        }

        for (Travelimage img : favorImgs) {
            img.setUserName(friend.getUserName());
        }

        request.getSession().setAttribute("friendsFavor", favorImgs);


        long totalNum = fdao.getCountByUid(friend.getUid());
        response.getWriter().println("{\"totalNum\":" + totalNum + "}");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid =  request.getParameter("uid");
        if (uid==null||uid.equals("")){
            response.sendRedirect("friends.jsp");
            return;
        }

        TraveluserDAO udao = new TraveluserDAO();
        Traveluser friend = udao.get(Integer.parseInt(uid));
        request.getSession().setAttribute("friend",friend);

        TravelimagefavorDAO fdao =  new TravelimagefavorDAO();

        List<Travelimagefavor> favors = fdao.getPartByUid(Integer.parseInt(uid),0,3);
        List<Travelimage> favorImgs = new ArrayList<>();


        TravelimageDAO idao = new TravelimageDAO();

        for (Travelimagefavor favor : favors) {
            favorImgs.add(idao.get(favor.getImageId()));
        }

        for (Travelimage img : favorImgs) {
            img.setUserName(udao.get(img.getUid()).getUserName());
        }

        request.getSession().setAttribute("friendsFavor", favorImgs);

        response.sendRedirect("friendFavor.jsp");

    }


}
