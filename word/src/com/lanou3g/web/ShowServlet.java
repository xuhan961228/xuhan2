package com.lanou3g.web;

import com.lanou3g.dao.UserDao;
import com.lanou3g.domain.User;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class ShowServlet extends HttpServlet {
	private UserDao userDao = new UserDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 指定允许其他域名访问
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		resp.addHeader("Access-Control-Allow-Origin","*");
// 响应类型
		resp.addHeader("Access-Control-Allow-Methods","POST");
// 响应头设置
		resp.addHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
		List<User> users;
		System.out.println("111");
		users = userDao.queryAll();

		JSONArray jsonArray =
				JSONArray.fromObject(users);
		resp.getWriter().write(jsonArray.toString());

	}
}
