package com.service;

import com.dao.CommentsDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "getCommentsServlet" ,urlPatterns = "/getCommentsServlet")
public class getCommentsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String iid = request.getParameter("iid");
        String order = request.getParameter("order");

        CommentsDAO cdao = new CommentsDAO();

        if (order.equals("time")) {
            request.getSession().setAttribute("comments", cdao.getAllByTimeForImg(Integer.parseInt(iid)));
        } else if (order.equals("hot")) {
            request.getSession().setAttribute("comments", cdao.getAllByHotForImg(Integer.parseInt(iid)));
        }

        response.getWriter().println("{\"message\": \"success\"}");

    }


}
