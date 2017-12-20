package Project;

import com.mysql.jdbc.Driver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Zuce {

    /**
     * {}就是匿名内部类实现ExecuteInter接口时
     * 复写的那个方法execute的方法体
     * conn就是execute方法的参数
     */


    public static void zuce(String name, String username, String password) throws SQLException, ClassNotFoundException, IOException ,ZuceExcePtion{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "123");
        Statement ss = conn.createStatement();
        ss.execute("INSERT INTO study VALUES('" + name + "','" + username + "','" + password + "')");
        conn.close();
    }


    public static void denglu(String u,String p) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "123");
        Statement ss = conn.createStatement();
        ss.execute("SELECT * FROM study WHERE username='"+u+"' AND password='"+p+"'");
        System.out.println("登录成功！！！");
    }
    public static void sanchu(String uu) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "123");
        Statement ss = conn.createStatement();
        ss.execute("DELETE FROM study WHERE username='"+uu+"'");
    }


}