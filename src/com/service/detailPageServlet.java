package com.service;

import com.dao.*;
import com.entity.Comments;
import com.entity.Travelimage;
import com.entity.Traveluser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "detailPageServlet", urlPatterns = "/detailPageServlet")
public class detailPageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String imageIdStr = request.getParameter("imageId");
        int imageId = Integer.parseInt(imageIdStr);
        TravelimageDAO dao = new TravelimageDAO();
        Travelimage img = dao.get(imageId);

        img.setHot(img.getHot() + 1);

        dao.update(img);

        TraveluserDAO udao = new TraveluserDAO();
        img.setUserName(udao.get(img.getUid()).getUserName());

        GeocountriesRegionsDAO rdao = new GeocountriesRegionsDAO();
        img.setCountry(rdao.get(img.getCountryRegionCodeIso()).getCountryRegionName());

        GeocitiesDAO cdao = new GeocitiesDAO();
        img.setCity(cdao.get(img.getCityCode()).getAsciiName());


        String username = (String) request.getSession().getAttribute("username");
        if (username != null && !username.equals("")) {
            Traveluser user = udao.getByName(username);

            List<String> historyImgIdList = new ArrayList<>(10);


            String oldHistoryImgIdStr = user.getHistoryImageId();

            if (oldHistoryImgIdStr != null) {
                String[] historyImgId = oldHistoryImgIdStr.split(",");
                historyImgIdList.addAll(Arrays.asList(historyImgId));

                historyImgIdList.remove(imageIdStr);
            }


            historyImgIdList.add(imageIdStr);

            String historyImgIdStr = String.join(",", historyImgIdList);

            user.setHistoryImageId(historyImgIdStr);
            udao.update(user);
        }

        //set comments session
        CommentsDAO comdao = new CommentsDAO();
        List<Comments> comments = comdao.getAllByHotForImg(imageId);
        request.getSession().setAttribute("comments", comments);


        request.getSession().setAttribute("image", img);
        response.sendRedirect("detail.jsp");
    }
}
