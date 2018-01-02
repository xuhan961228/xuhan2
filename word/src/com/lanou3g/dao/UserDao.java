package com.lanou3g.dao;

import com.lanou3g.domain.User;
import com.lanou3g.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class UserDao {
	private QueryRunner qr = new QueryRunner();

	public boolean insertUser(User user){
		String sql = "insert into table_name values(?,?)";
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			qr.update(conn,sql,user.getUsername(),user.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
	}
		JdbcUtil.close(conn);
	return true;
	}

	public List<User> queryAll() {
		System.out.println("222");
		String sql = "select * from table_name";
		Connection conn = null;
		conn = JdbcUtil.getConnection();
		try {
			List<User> users =

					qr.query(conn, sql, new BeanListHandler<User>(User.class));

			System.out.println(users);

			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn);
		}
		return null;
	}

	public void tianjia(User user) throws SQLException {
		String sql="inser into table_name values(?,?)";
		Connection conn=null;
		 conn=JdbcUtil.getConnection();
		 qr.update(conn, sql, user.getUsername(), user.getPassword());
		 conn.close();
//		qr.update(conn,sql,user.getUsername(),user.getPassword());
	}
	public void chaxun(){

		
	}
	public void denglu(User user){
		String sql="select username from table_name";
		Connection conn=null;
		conn=JdbcUtil.getConnection();


	}




}
