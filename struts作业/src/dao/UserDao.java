package dao;

import bean.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import ulit.C3P0Util;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * xuhan
 * 2018/1/15
 */
public class UserDao {
QueryRunner qr=new QueryRunner();
public void insertUser(User user) throws SQLException {

    Connection connection = C3P0Util.getConnection();
    String sql="insert into user values(?,?)";
    try {
        System.out.println(user.getUsername()+user.getPassword()+"存的时候涨回去奥密码");
        qr.update(connection,sql,user.getUsername(),user.getPassword());
    } catch (SQLException e) {
        e.printStackTrace();
    }finally {
        connection.close();
    }
}
public String findPassword(String username) throws SQLException {
    Connection connection = C3P0Util.getConnection();
    String sql="select password from user where username=?";
    try {
        String query = qr.query(connection, sql, new ScalarHandler<String>(), username);
        return query;
    } catch (SQLException e) {
        e.printStackTrace();
    }finally {
        connection.close();
    }
    return null;
}



}
