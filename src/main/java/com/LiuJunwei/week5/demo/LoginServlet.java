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
        String driver = "com.mysql.jdbc.Driver";
        String password = "123456";
        String url = "jdbc:mysql://localhost:3306/userdb?serverTimezone=UTC";
        String username = "root";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("init()-->"+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        PrintWriter writer=response.getWriter();
        try {
            ResultSet rs;
            PreparedStatement sql;
            sql = con.prepareStatement("SELECT * FROM usertable WHERE username=? AND password=?");
            sql.setString(1, username);
            sql.setString(2, password);
            rs = sql.executeQuery();
            boolean flag = false;
            while(rs.next()) {
                flag = true;
                break;
            }
            if (flag) {
                writer.println("Login Success!!!");
                writer.println("Welcome" + username);
            } else {
                writer.println("Username or Password Error!!!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
