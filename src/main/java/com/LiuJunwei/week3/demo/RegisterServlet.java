package com.LiuJunwei.week3.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "RegisterServlet",value = "/week2/register")
public class RegisterServlet extends HttpServlet {
    public Connection con;
    public void init() {
        try {
            Class.forName(getServletConfig().getServletContext().getInitParameter("driver"));
            con = DriverManager.getConnection(
                    getServletConfig().getServletContext().getInitParameter("url"),
                    getServletConfig().getServletContext().getInitParameter("Username"),
                    getServletConfig().getServletContext().getInitParameter("Password")
                  );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id;
        String username=request.getParameter("username");
        id = username;
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String sex=request.getParameter("sex");
        String birth=request.getParameter("birth");
        PrintWriter writer=response.getWriter();
        String[][] ret=new String[100][10];
        int cnt=0;
        try {
            Statement createDbStatement = con.createStatement();
            String sql1="insert into usertable(id,username,password,email,sex,birth) values('"+id+"','"+username+"','"+password+"','"+email+"','"+sex+"','"+birth+"')";
            createDbStatement.executeUpdate(sql1);
            String sql2="select * from usertable";
            ResultSet rs=createDbStatement.executeQuery(sql2);
            while(rs.next()) {
                ret[cnt][0]=rs.getObject(1).toString().trim();
                ret[cnt][1]=rs.getObject(2).toString().trim();
                ret[cnt][2]=rs.getObject(3).toString().trim();
                ret[cnt][3]=rs.getObject(4).toString().trim();
                ret[cnt][4]=rs.getObject(5).toString().trim();
                ret[cnt++][5]=rs.getObject(6).toString().trim();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        response.sendRedirect("login.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
