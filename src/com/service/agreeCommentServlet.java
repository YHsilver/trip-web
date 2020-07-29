package com.service;

import com.dao.CommentsDAO;
import com.entity.Comments;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "agreeCommentServlet", urlPatterns = "/agreeCommentServlet")
public class agreeCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        if (username == null || username.equals("")) {
            response.getWriter().println("{\"message\": \"user_not_exist\"}");
            return;
        }

        String cid = request.getParameter("cid");

        CommentsDAO commentsDAO = new CommentsDAO();
        Comments comments = commentsDAO.getById(Integer.parseInt(cid));
        comments.setHot(comments.getHot() + 1);
        commentsDAO.updateHeat(comments);

        List<Comments> commentsList = (List<Comments>) request.getSession().getAttribute("comments");

        for (Comments comment : commentsList) {
            if (comment.getCid() == Integer.parseInt(cid)) {
                comment.setHot(comment.getHot() + 1);
            }
        }

        request.getSession().setAttribute("comment",commentsList);

        response.getWriter().println("{\"message\": \"success\"}");
    }
}
