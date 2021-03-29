package com.LiuJunwei.week4.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        value = "/config",
        initParams = {
                @WebInitParam(name = "name",value = "LiuJunwei"),
                @WebInitParam(name = "studentId",value = "2019211001000812")
        }
)


public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("name:"+getServletConfig().getInitParameter("name"));
        writer.println("studentId:"+getServletConfig().getInitParameter("studentId"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
