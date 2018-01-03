package com.lanou3g.servlet;

import com.lanou3g.dao.UserDao;
import com.lanou3g.domain.Book;
import com.lanou3g.domain.User;
import net.sf.json.JSONArray;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

        try {
            User user = userDao.findByName(username);
//            System.out.println(user);
            if (user!=null&&user.getPassword().equals(password)){
//                System.out.println("1111");
                List<Book> books = userDao.queryAll();
//                HttpSession session1 = request.getSession();

                JSONArray jsonArray = JSONArray.fromObject(books);
                System.out.println(jsonArray.toString());

//                Map<String, String[]> parameterMap = request.getParameterMap();
//                BeanUtils.populate(book,parameterMap);
//                for (Map.Entry<String, String[]> stringEntry : parameterMap.entrySet()) {
//                    System.out.println("------------"+stringEntry.getKey() + Arrays.toString(stringEntry.getValue()));
//                }

                getServletContext().setAttribute("book",books);
                


                response.sendRedirect("http://localhost:8080/zhuye.jsp");
            }else {
//                System.out.println("ddd");
                response.setStatus(302);
                response.sendRedirect("http://localhost:8080/login.html");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        List<Book> books = userDao.queryAll();
//        System.out.println(books);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
