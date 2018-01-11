package amd.web;

import amd.dao.BookDao;
import amd.dao.CategoryDao;

import org.apache.commons.beanutils.BeanUtils;
import userbook.domain.Category;
import util.BaseServlet;
import util.JdbcUtil;
import util.Uuid;

import javax.jws.WebService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "UserServlet", urlPatterns = "/amd")
public class AmdServlet extends BaseServlet {

    BookDao bookDao=new BookDao();
    CategoryDao categoryDao=new CategoryDao();
//    Category category = new Category();
    userbook.domain.Book book=new userbook.domain.Book();

    public String addbook(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
        
        System.out.println("111111111111111111111");
        String bname = request.getParameter("bname");
        Map<String, String[]> parameterMap = request.getParameterMap();
        BeanUtils.populate(book,parameterMap);
        book.setBid(Uuid.getRandomString());
        bookDao.insertBook(book);



        return "f:/adminjsps/admin/book/list.jsp";
    }
    public String selects(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        List<userbook.domain.Category> allbooks = categoryDao.allbooks();
        request.getSession().setAttribute("leixing",allbooks);


        return "f:/adminjsps/admin/category/list.jsp";

    }

    public String addclassify(HttpServletRequest request, HttpServletResponse response) throws SQLException, InvocationTargetException, IllegalAccessException {
//        Map<String, String[]> parameterMap = request.getParameterMap();
//        BeanUtils.populate(category,parameterMap);
//        System.out.println("进来了");
        String cname = request.getParameter("cname");
//        Category category = new Category();
//        category.setCname(cname);

        userbook.domain.Category selectclassify = categoryDao.selectclassify(cname);
        if (selectclassify==null){
            Category category = new Category();
            category.setCid(Uuid.getRandom());
            category.setCname(cname);
            categoryDao.addclassify(category);
            request.setAttribute("tianjia",category);

//            ${requestSore.tianjia.cname}

            return "f:/adminjsps/admin/category/add.jsp";
        }else {
            request.setAttribute("shibai","这个分类已存在");
            return "f:/adminjsps/admin/category/add.jsp";
        }


    }

    public String modificationcategory(HttpServletRequest request,HttpServletResponse response){



        return "f:/adminjsps/admin/category/mod.jsp";
    }
    public String deletebooks(HttpServletRequest request,HttpServletResponse response){
        String cname = request.getParameter("cname");
        request.getSession().setAttribute("ccc",cname);
        return "f:/adminjsps/admin/category/del.jsp";
    }
    public String delete(HttpServletRequest request,HttpServletResponse response){
        String cname = request.getParameter("cname");
        System.out.println(cname);
        return "f:/adminjsps/admin/category/del.jsp";
    }

}
