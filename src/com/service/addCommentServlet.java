package com.service;

import com.dao.CommentsDAO;
import com.entity.Comments;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addCommentServlet", urlPatterns = "/addCommentServlet")
public class addCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        if (username == null || username.equals("")) {
            response.getWriter().println("{\"message\": \"user_not_exist\"}");
            return;
        }

        String comment = request.getParameter("comment");
        String imageId = request.getParameter("imageId");


        CommentsDAO commentsDAO = new CommentsDAO();

        Comments comments = new Comments(username, Integer.parseInt(imageId), comment);

        commentsDAO.save(comments);


        request.getSession().setAttribute("comments",commentsDAO.getAllByHotForImg(Integer.parseInt(imageId)));

        response.getWriter().println("{\"message\": \"success\"}");
    }


}
