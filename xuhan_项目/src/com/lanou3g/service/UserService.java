package com.lanou3g.service;

import com.lanou3g.dao.UserDao;
import com.lanou3g.domain.User;
import com.lanou3g.service.exception.LoginException;
import com.lanou3g.service.exception.NoUsernameException;
import com.lanou3g.service.exception.PasswordWrongException;
import com.lanou3g.service.exception.RegisterExcuption;
import util.BaseServlet;

import java.sql.SQLException;

public class UserService {
    UserDao userDao=new UserDao();
    public User login(User user) throws SQLException, NoUsernameException, PasswordWrongException {
        User fromDB = userDao.findByName(user.getUsername());
        if (fromDB==null){
            throw new NoUsernameException();
        }
        if (!fromDB.getPassword().equals(user.getPassword())){
            throw new PasswordWrongException();
        }
        return fromDB;
    }
    public void register(User user) throws SQLException, RegisterExcuption {
        if (userDao.findByName(user.getUsername())==null){
            System.out.println("cun");
            userDao.insertUser(user);
        }else {
           throw new RegisterExcuption();
        }
    }
    public boolean reg(String user) throws SQLException, RegisterExcuption {
        User byName = userDao.findByName(user);

        if (byName==null){
            System.out.println("判断存储");
            return true;
        }else {
            return false;
        }
    }

}
