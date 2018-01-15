package ulit;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by travelround on 17/4/18.
 */
public class C3P0Util {


    // 得到一个数据源(连接池)
    private static DataSource dataSource = new ComboPooledDataSource();
//    获得连接
    public static Connection getConnection() {

        try {
//            返回
            return dataSource.getConnection();
        } catch (SQLException e) {
//            异常
            throw new RuntimeException("服务器忙...");
        }
    }

    public static void release(ResultSet resultSet, Statement stmt, Connection connection) {
        if (resultSet != null) {
            try {
//                关闭
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resultSet = null;
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection = null;
        }
    }

}
