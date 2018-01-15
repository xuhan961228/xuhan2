package servlet.service;

import bean.User;
import dao.UserDao;

import java.sql.SQLException;

/**
 * xuhan
 * 2018/1/15
 */
public class UserServlice {

    public boolean register(User user) throws SQLException {

        String password = new UserDao().findPassword(user.getUsername());
        System.out.println(password+"注册判断密码");
        if (password!=null){
            System.out.println("you l ");
            return false;
        }else {
            System.out.println("2");
            new UserDao().insertUser(user);
            return true;
        }
    }
    public boolean login(User user) throws SQLException {

        String password = new UserDao().findPassword(user.getUsername());
        System.out.println(password+"denglu 判断");
        if (password.equals(user.getPassword())){
            return true;
        }else {
            return false;
        }


    }
}
