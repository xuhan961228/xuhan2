package Project;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
    static {
        try {
            Properties prop=new Properties();

            prop.load(new FileReader("src/jdbc.properties"));

            String driverName=prop.getProperty("driverName");

            url = prop.getProperty("url");
            //数据库账号密码
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            //数据库名
            database = prop.getProperty("database");
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage()+"\n\t\t"+"请将配置文件jdbc。properties放在src目录下");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String url;
    private static String user;
    private static String password;
    private static String database;

    public static Connection getConnection(){
        try {
            Connection conn = DriverManager.getConnection
                    (url+database,user,password);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void execute(ExecuteInter e){
        try {
            Connection con = DriverManager.getConnection
                    (url+database,user,password);
           e.execute(con).close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public static void showRS(ResultSet rs){
        try {
            while (rs.next()){
                try {
                    System.out.println(rs.getString(1)+"\t");
                    System.out.println(rs.getString(2)+"\t");
                    System.out.println(rs.getString(3)+"\t");
                    System.out.println(rs.getString(4)+"\t");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
