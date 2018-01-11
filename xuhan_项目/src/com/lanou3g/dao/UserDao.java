package com.lanou3g.dao;

import com.lanou3g.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {
    QueryRunner qr=new QueryRunner();
    public void insertUser(User user){
        String sql="insert into tb_user values(?,?,?,?,?,?)";
        Connection conn=null;
        try {
            conn = JdbcUtil.getConnection();
            qr.update(conn,sql,user.getUid(),user.getUsername(),user.getPassword(),user.getEmail(),user.getCode(),user.getState());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcUtil.close(conn);
    }
    public User findByName(String username) throws SQLException {
        String sql = "select * from tb_user where username=?";
        Connection conn = null;
        conn = JdbcUtil.getConnection();
//        System.out.println(username);
        try {
            User user = qr.query(conn, sql, new BeanHandler<User>(User.class),username);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }
        return null;
    }
    public User updateState(String username) throws SQLException {
        String sql="UPDATE tb_user SET state=1 where username=?";
        Connection conn = null;
        conn = JdbcUtil.getConnection();
        User user = null;
        try {
            user = qr.query(conn, sql, new BeanHandler<User>(User.class),username);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }


        return null;
    }



    public User findByusername(String username) throws SQLException {
        String sql = "select uid from tb_user where username=?";
        Connection conn = null;
        conn = JdbcUtil.getConnection();
//        System.out.println(username);
        try {
            User user = qr.query(conn, sql, new BeanHandler<User>(User.class),username);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }
        return null;
    }

}
