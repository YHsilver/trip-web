package com.service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloAjax", urlPatterns = "/HelloAjax")
public class HelloAjax extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("name") + ":send post");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("post received");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("name") + ":send get");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("get received");
    }
}