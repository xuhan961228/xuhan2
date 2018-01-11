package amd.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import userbook.domain.Book;
import userbook.domain.Category;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CategoryDao {
    QueryRunner qr=new QueryRunner();
    public List<Category> allbooks() throws SQLException {
        String sql = "select * from category";
        Connection conn = null;
        conn = JdbcUtil.getConnection();
        try {
            List<Category> user = qr.query(conn, sql, new BeanListHandler<Category>(Category.class));
            return (List<Category>) user;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }
        return null;
    }


    public void addclassify(Category category){
        String sql="insert into category values(?,?)";
        Connection conn=null;
        try {
            conn = JdbcUtil.getConnection();
            qr.update(conn,sql,category.getCid(),category.getCname());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcUtil.close(conn);
    }
    public Category selectclassify(String s) throws SQLException {
        String sql ="select * from category where cname=?";
        Connection conn=null;
        conn=JdbcUtil.getConnection();
        try {
            Category query = qr.query(conn, sql, new BeanHandler<Category>(Category.class),s);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }
        return null;
    }



    public void addBook(Book category){
        String sql="insert into category values(?,?)";
        Connection conn=null;
        try {
            conn = JdbcUtil.getConnection();
            qr.update(conn,sql,category);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcUtil.close(conn);
    }
}
