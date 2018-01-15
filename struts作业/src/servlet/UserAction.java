package servlet;

import bean.User;
import com.opensymphony.xwork2.ActionSupport;
import dao.UserDao;
import org.apache.struts2.ServletActionContext;
import servlet.service.UserServlice;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * xuhan
 * 2018/1/15
 */
public class UserAction extends ActionSupport {
    public String register() throws SQLException, ServletException, IOException {
        User user=new User();
        UserDao userDao=new UserDao();
        String username = ServletActionContext.getRequest().getParameter("username");
        String password = ServletActionContext.getRequest().getParameter("password");
        System.out.println(username+"账号");
        System.out.println(password+"密码");
        System.out.println("----------------------");
        user.setUsername(username);
        user.setPassword(password);

        System.out.println(user.getUsername()+"++++");
        System.out.println(user.getPassword()+"++++");
//        userDao.insertUser(user);

//        String pass = userDao.findPassword(username);
//        System.out.println(pass+"----");
//        if (pass!=null){
//            System.out.println("you l ");
//        }else {
//            new UserDao().insertUser(user);
//        }
        UserServlice userServlice=new UserServlice();
        System.out.println("999");
        boolean register = userServlice.register(user);
        if (register==true){
            ServletActionContext.getRequest().getRequestDispatcher
                    ("login.jsp").forward(ServletActionContext.getRequest(),
                    ServletActionContext.getResponse());
            return null;
        }else {
            return SUCCESS;
        }

    }

    public String login() throws SQLException, ServletException, IOException {
        String username = ServletActionContext.getRequest().getParameter("username");
        String password = ServletActionContext.getRequest().getParameter("password");
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        UserServlice userServlice=new UserServlice();
        boolean login = userServlice.login(user);
        if (login==true){
            System.out.println("++++++++++++++++++++++++++++");
            ServletActionContext.getRequest().getRequestDispatcher
                    ("index.jsp").forward(ServletActionContext.getRequest(),
                    ServletActionContext.getResponse());
            return null;
        }else {
            return SUCCESS;
        }


    }

}
