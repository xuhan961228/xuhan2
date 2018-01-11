package com.lanou3g.web;

import com.lanou3g.dao.UserDao;
import com.lanou3g.domain.User;
import com.lanou3g.service.UserService;
import com.lanou3g.service.exception.LoginException;
import com.lanou3g.service.exception.RegisterExcuption;
import org.apache.commons.beanutils.BeanUtils;
import util.BaseServlet;
import util.Postbox;
import util.Uuid;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "UsersServlet",urlPatterns = "/user")
public class UsersServlet extends BaseServlet {
    User user=new User();
    UserService userService=new UserService();
    UserDao userDao=new UserDao();

    public String register(HttpServletRequest request, HttpServletResponse response) throws SQLException, InvocationTargetException, IllegalAccessException, ServletException, IOException, RegisterExcuption {
        System.out.println("------------");
        String email = request.getParameter("email");
        Map<String, String[]> parameterMap = request.getParameterMap();
        String uid = Uuid.getString();
        user.setUid(uid);
        String s = Uuid.getString();
        String ss=s+uid;
        user.setCode(ss);
        user.setEmail(email);
        user.setState(0);
        BeanUtils.populate(user,parameterMap);
        String username = request.getParameter("username");
        boolean t = false;

        t = userService.reg(username);

        if (t==true){
            Postbox.run(user.getEmail(),user.getCode());
            return "r:/jsps/user/yanzheng.jsp";
        }else {
            System.out.println("不能注册");
            request.getSession().setAttribute("ycz","账号已存在！！！");
            return "f:/jsps/user/regist.jsp";
        }
    }
    public String yanzheng(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String jihuoma = request.getParameter("jihuoma");
        System.out.println("进入验证servlet");
        userDao.insertUser(user);
        if (jihuoma.equals(user.getCode())){
            System.out.println("激活码匹配正确");

            userDao.updateState(user.getUsername());
            return "f:/jsps/msg.jsp";
        }else {
            System.out.println("激活码匹配不正确");
//            request.getRequestDispatcher("/jsps/user/login.jsp").forward(request,response);
            return "f:/jsps/user/login.jsp";
        }
    }
    public String login(HttpServletRequest request,HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
        System.out.println("11111111111111111111111");
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        request.getSession().setAttribute("username",username);
        user.setUsername(username);
        user.setPassword(password);
        try {
            User login = userService.login(user);
            if ( login.getPassword().equals(password)){
                if (login.getState()==1){
                    return "r:/jsps/main.jsp";
                }else {
                    request.getServletContext().setAttribute("mjh","没激活账号,请输入激活的账号");
                    return "r:/index.jsp";
                }
            }else {
                System.out.println("密码不匹配");
                return "r:/jsps/user/login.jsp";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (LoginException e) {
            request.getSession().setAttribute("yhmbcz",e.getMessage());
        }
        return null;
    }
    public String jihuo(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String jihuoma = request.getParameter("jihuoma");
        if (jihuoma.equals("123")){
            return "r:/jsps/main.jsp";
        }else {
            request.getServletContext().setAttribute("a","激活码错误");
            return "f:/index.jsp";
        }
    }





}
