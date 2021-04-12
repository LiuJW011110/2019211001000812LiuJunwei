package com.LiuJunwei.week5.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
        super.init();
        /*String driver = "com.mysql.jdbc.Driver";
        String password = "123456";
        String url = "jdbc:mysql://localhost:3306/userdb?serverTimezone=UTC";
        String username = "root";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("init()-->"+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/
        con = (Connection)getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        Statement createDbStatement = null;
        PrintWriter writer=resp.getWriter();
        boolean flag = false;
        try {
            createDbStatement = con.createStatement();
            String dbRequire="select * from usertable where username='"+username+"' and password='"+password+"'";
            System.out.println(dbRequire);
            ResultSet resultDb=createDbStatement.executeQuery(dbRequire);
            if(resultDb.next()) {
                flag = true;
                req.setAttribute("id",resultDb.getInt("id"));
                req.setAttribute("username",resultDb.getString("username"));
                req.setAttribute("password",resultDb.getString("password"));
                req.setAttribute("email",resultDb.getString("email"));
                req.setAttribute("gender",resultDb.getString("sex"));
                req.setAttribute("birthDate",resultDb.getString("birth"));
                req.getRequestDispatcher("userInfo.jsp").forward(req,resp);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        if (!flag) {
            req.setAttribute("massage","username or Password Error!");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
