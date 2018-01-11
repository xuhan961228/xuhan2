package userbook.web;

import com.sun.javafx.collections.MappingChange;
import userbook.dao.BookDao;
import userbook.domain.Book;
import userbook.domain.Category;
import userbook.domain.ShoppingCart;
import util.BaseServlet;
import util.Time;
import util.Uuid;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "BookServlet", urlPatterns = "/se")
public class BookServlet extends BaseServlet {
    Category category=new Category();
    BookDao bookDao=new BookDao();
    Book book=new Book();

    public String books(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<Book> allbooks = bookDao.allbooks();
        request.setAttribute("books",allbooks);
        return "f:/jsps/book/list.jsp";
    }
    public String javase(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Category bycname = bookDao.findBycname("JavaSE");
        int cid = bycname.getCid();
        List<Book> b = bookDao.b(cid);
        request.setAttribute("se",b);
        return "f:/jsps/book/list.jsp";
    }
    public String javaee(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Category bycname = bookDao.findBycname("JavaEE");
        int cid = bycname.getCid();
        List<Book> eebook = bookDao.b(cid);
        request.setAttribute("ee",eebook);
        return "f:/jsps/book/list.jsp";
    }
    public String javajs(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Category bycname = bookDao.findBycname("Javascript");
        int cid = bycname.getCid();
        List<Book> jsbook = bookDao.b(cid);
        request.setAttribute("js",jsbook);
        return "f:/jsps/book/list.jsp";
    }
    public String xq(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String bid = request.getParameter("bid");
        ShoppingCart allbooksBybname = bookDao.allbooksBybid(bid);
        request.getSession().setAttribute("xxx",allbooksBybname);
        return "f:/jsps/book/desc.jsp";
    }
    public String shoppingCart(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String count = request.getParameter("count");
        String bid = request.getParameter("bid");
        String price = request.getParameter("price");
        System.out.println(price+"价格-----------------");
        String time = Time.time();
        int oid = Uuid.getRandom();
        ShoppingCart book = bookDao.allbooksBybid(bid);
        //物品数量
        book.setCount(count);
        request.getSession().setAttribute("count",count);

        Map<String,ShoppingCart> g = (Map<String,ShoppingCart>)request.getSession().getAttribute("gwc");

        if(g==null){
            g = new HashMap<String, ShoppingCart>();
        }
        System.out.println(g+"添加前");
        g.put(book.getBid(),book);
        System.out.println(g+"添加后");


        request.getSession().setAttribute("gwc",g);

        request.getSession().setAttribute("time",time);
        request.getSession().setAttribute("oid",oid);
        return "f:/jsps/cart/list.jsp";
    }





public String removeAll(HttpServletRequest request,HttpServletResponse response){
    request.getSession().removeAttribute("gwc");
    return "f:/jsps/cart/list.jsp";
}
    public String remove(HttpServletRequest request,HttpServletResponse response) throws SQLException {
        String bid = request.getParameter("bid");
        System.out.println(bid);
        Map<String,ShoppingCart> g =
                (Map<String,ShoppingCart>)request.getSession().getAttribute("gwc");
        g.remove(bid);
//        request.getSession().setAttribute("gwcs",g);

        return "f:/jsps/cart/list.jsp";
    }

public String dropout(HttpServletRequest request,HttpServletResponse response){
    request.getSession().removeAttribute("username");
    return "f:/jsps/main.jsp";
}
    public String buy(HttpServletRequest request,HttpServletResponse response){

        String image = request.getParameter("price");
        System.out.println(image+"价格");
        request.getSession().setAttribute("jiage",image);
        System.out.println(request.getSession().getAttribute("username"));

        request.getSession().setAttribute("gg",image);
        Map<String,ShoppingCart> g =
                (Map<String,ShoppingCart>)request.getSession().getAttribute("gwc");
        System.out.println(g+"goumaiche");
        request.getSession().setAttribute("order",g);
        return "f:/jsps/order/desc.jsp";
    }
    public String gouwuche(HttpServletRequest request,HttpServletResponse response) {
        System.out.println(request.getSession().getAttribute("username"));

        Map<String,ShoppingCart> g =
                (Map<String,ShoppingCart>)request.getSession().getAttribute("gwc");
        System.out.println(g.values());


//        for (ShoppingCart shoppingCart : g.values()) {
//            System.out.println(shoppingCart);
//
//        }



        return "f:jsps/cart/list.jsp";
    }






}
