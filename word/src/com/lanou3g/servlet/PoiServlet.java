package com.lanou3g.servlet;

import com.lanou3g.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PoiServlet",urlPatterns = "/zhuye")
public class PoiServlet extends HttpServlet {
    UserDao userDao=new UserDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response
//        getServletContext().setAttribute();

        response.getWriter().write(String.valueOf(userDao.queryAll()));

    }
}
