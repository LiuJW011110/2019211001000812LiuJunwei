package com.LiuJunwei.week6;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener()
public class JDBCServletContextListener implements ServletContextListener {
    Connection con = null;
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed).
         You can initialize servlet context related data here.
      */
        System.out.println("inti...");
        try {
            Class.forName(sce.getServletContext().getInitParameter("driver"));
            con = DriverManager.getConnection(sce.getServletContext().getInitParameter("url"),sce.getServletContext().getInitParameter("Username"),sce.getServletContext().getInitParameter("Password"));
            System.out.println(con);
        } catch (Exception e) {
            System.out.println(e);
        }
        sce.getServletContext().setAttribute("con",con);
    }
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}