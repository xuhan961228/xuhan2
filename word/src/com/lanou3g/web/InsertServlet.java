package com.lanou3g.web;

import com.lanou3g.dao.UserDao;
import com.lanou3g.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class InsertServlet extends HttpServlet {
	private UserDao userDao = new UserDao();


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Map<String, String[]> parameterMap =
				req.getParameterMap();

		User u = new User();
		try {
			//可以直接把map中的内容设置到对象上
			BeanUtils.populate(u,parameterMap);

		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		userDao.insertUser(u);
		resp.getWriter().write("SUCCESS");
	}
}
