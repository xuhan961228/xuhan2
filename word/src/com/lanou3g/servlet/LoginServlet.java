package com.lanou3g.servlet;

import com.lanou3g.dao.UserDao;
import com.lanou3g.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserDao userDao=new UserDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        if (username.equals("xuhan")&&password.equals("123")){
            response.setStatus(302);
            response.sendRedirect("http://localhost:8080/zhuye.html");
            System.out.println("CCCCCCCCCCCC");
        }else {
            System.out.println("XXXXXXXXXXX");
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
//            dispatcher.include(request,response);
            response.setStatus(302);
            response.sendRedirect("http://localhost:8080/login.html");
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
