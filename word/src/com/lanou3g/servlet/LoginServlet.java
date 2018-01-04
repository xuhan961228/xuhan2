package com.lanou3g.servlet;

import com.lanou3g.dao.UserDao;
import com.lanou3g.domain.Book;
import com.lanou3g.domain.User;
import net.sf.json.JSONArray;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserDao userDao=new UserDao();
    private Book book = new Book();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        session.setAttribute("username",username);
        session.setAttribute("password",password);
        Cookie cookie=new Cookie("username",username);
        cookie.setMaxAge(60*60*24*30);
        response.addCookie(cookie);
//        cookie.setPath();

        System.out.println(username+"ddddddddddd");
        try {
            User user = userDao.findByName(username);
            if (user!=null&&user.getPassword().equals(password)){
                ServletContext servletContext = request.getServletContext();
                servletContext.setAttribute("username",username);
                servletContext.setAttribute("password",password);



                response.sendRedirect("http://localhost:8080/zhuye.jsp");
            }else {
                response.setStatus(302);
                response.sendRedirect("http://localhost:8080/login.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
