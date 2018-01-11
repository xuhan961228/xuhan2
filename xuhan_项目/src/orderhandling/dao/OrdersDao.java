package orderhandling.dao;


import com.lanou3g.domain.User;
import orderhandling.domain.Orders;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import userbook.domain.Book;
import userbook.domain.ShoppingCart;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class OrdersDao {

    QueryRunner qr=new QueryRunner();
    public boolean intoorders(int o, String or, String t, int s, String u, String a){
        String sql="insert into orders values(?,?,?,?,?,?)";
        Connection conn=null;
        try {
            conn = JdbcUtil.getConnection();
            qr.update(conn,sql,o,or,t,s,u,a);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcUtil.close(conn);
        return true;
    }
    public int selecttotal(int oid) throws SQLException {
        String sql = "select state from orders where oid=?";
        Connection conn = null;
        conn = JdbcUtil.getConnection();
        try {
            int orders = qr.query(conn, sql,new ScalarHandler<Integer>(),oid);
            return orders;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }
       return 1;
    }
}
