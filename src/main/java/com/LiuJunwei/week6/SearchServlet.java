package com.LiuJunwei.week6;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SearchServlet",value = "/search")
public class SearchServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sel=request.getParameter("search");
        String sea=request.getParameter("txt");
        System.out.println(sel);
        if(sel.equals("baidu")) {
            response.sendRedirect("https://www.baidu.com/s?wd="+sea);
        } else if(sel.equals("bing")) {
            response.sendRedirect("https://cn.bing.com/search?q="+sea);
        } else if(sel.equals("google")) {
            response.sendRedirect("https://www.google.com/search?q="+sea);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}