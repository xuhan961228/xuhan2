package amd.dao;


import com.lanou3g.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import userbook.domain.Book;
import userbook.domain.ShoppingCart;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class BookDao {
    QueryRunner qr=new QueryRunner();
    public boolean insertBook(Book book){
        String sql="insert into book values(?,?,?,?,?,?)";
        Connection conn=null;
        try {
            conn = JdbcUtil.getConnection();
            qr.update(conn,sql,book.getBid(),book.getBname(),book.getImage(),book.getPrice(),book.getAuthor(),book.getCid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcUtil.close(conn);
        return true;
    }


}
