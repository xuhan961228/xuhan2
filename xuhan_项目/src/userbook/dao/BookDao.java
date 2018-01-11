package userbook.dao;

import userbook.domain.Book;
import userbook.domain.Category;
import userbook.domain.ShoppingCart;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookDao {
    QueryRunner qr=new QueryRunner();
    public Category findBycname(String cname) throws SQLException {
        String sql = "select * from category where cname=?";
        Connection conn = null;
        conn = JdbcUtil.getConnection();
        try {
            Category user = qr.query(conn, sql, new BeanHandler<Category>(Category.class),cname);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }
        return null;
    }
public List<Book> b(int id) throws SQLException {
    String sql = "select * from book where cid=?";
    Connection conn = null;
    conn = JdbcUtil.getConnection();
    try {
        List<Book> user = qr.query(conn, sql, new BeanListHandler<Book>(Book.class),id);
        return (List<Book>) user;
    } catch (SQLException e) {
        e.printStackTrace();
    }finally {
        conn.close();
    }
    return null;
}
    public List<Book> allbooks() throws SQLException {
        String sql = "select * from book";
        Connection conn = null;
        conn = JdbcUtil.getConnection();
        try {
            List<Book> user = qr.query(conn, sql, new BeanListHandler<Book>(Book.class));
            return (List<Book>) user;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }
        return null;
    }
    public ShoppingCart allbooksBybid(String bid) throws SQLException {
        String sql = "select * from book where bid=?";
        Connection conn = null;
        conn = JdbcUtil.getConnection();
        try {
            ShoppingCart user = qr.query(conn, sql, new BeanHandler<ShoppingCart>(ShoppingCart.class),bid);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }
        return null;
    }
    public Book allbooksBybname(String bname) throws SQLException {
        String sql = "select * from book where bname=?";
        Connection conn = null;
        conn = JdbcUtil.getConnection();
        try {
            Book user = qr.query(conn, sql, new BeanHandler<Book>(Book.class),bname);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }
        return null;
    }


}
