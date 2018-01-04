package com.lanou3g.servlet;

import com.lanou3g.dao.UserDao;
import com.lanou3g.domain.Book;
import com.lanou3g.domain.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by zyf on 2018/1/3.
 */
@WebServlet(name = "ShowServlet",urlPatterns = "/zhuye")
public class ShowServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");


		UserDao userDao=new UserDao();
		List<Book> books = userDao.queryAll();
//		System.out.println(books);
		JSONArray jsonArray = JSONArray.fromObject(books);
		response.getWriter().write(jsonArray.toString());


	}
}
