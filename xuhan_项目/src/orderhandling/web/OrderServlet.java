package orderhandling.web;

import com.lanou3g.dao.UserDao;
import com.lanou3g.domain.User;
import orderhandling.dao.OrdersDao;
import orderhandling.domain.Orders;
import userbook.domain.ShoppingCart;
import util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "OrderServlet", urlPatterns = "/order")
public class OrderServlet extends BaseServlet {
    public String myorder(HttpServletRequest request, HttpServletResponse response){
        Map<String,ShoppingCart> g =
                (Map<String,ShoppingCart>)request.getSession().getAttribute("gwc");
        request.getSession().setAttribute("order",g);
        System.out.println(request.getSession().getAttribute("username"+"---"));

        return "f:/jsps/order/list.jsp";
    }
    public String remove(HttpServletRequest request, HttpServletResponse response){
        String bid = request.getParameter("bid");
        System.out.println(bid);
        Map<String,ShoppingCart> g =
                (Map<String,ShoppingCart>)request.getSession().getAttribute("gwc");
        g.remove(bid);
        request.getSession().setAttribute("order",g);
        return "f:/jsps/order/list.jsp";
    }
    public String payment(HttpServletRequest request, HttpServletResponse response){

    return "f:/jsps/order/desc.jsp";
    }
    public String jiesuan(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        System.out.println("--------");
        Map<String,ShoppingCart> g =
                (Map<String,ShoppingCart>)request.getSession().getAttribute("gwc");
        System.out.println(g);
        String username = (String) request.getSession().getAttribute("username");
        String time = (String) request.getSession().getAttribute("time");
        int oid = (int) request.getSession().getAttribute("oid");
        Object count = request.getSession().getAttribute("count");
        String address = request.getParameter("address");
        String jia = request.getParameter("jia");
        User byusername = new UserDao().findByusername(username);
        String uid = byusername.getUid();
        new OrdersDao().intoorders(oid,time,jia,1,uid,address);


        return "f:/jsps/order/desc.jsp";
    }
    public String goods(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        int oid = (int) request.getSession().getAttribute("oid");

        Orders orders=new Orders();



        System.out.println(orders.getOid()+"显示");

        int selecttotal = new OrdersDao().selecttotal(oid);
        System.out.println(selecttotal+"控制证");
        if (selecttotal==1){
            request.getSession().setAttribute("ggg","还没发货呢！！");
            System.out.println("+++=-=-=-==-=-");
            return "f:/jsps/order/msg.jsp";
        }else if (selecttotal==2){
            request.getSession().setAttribute("ggg","东西好没到呢！！！");
            return "f:/jsps/order/msg.jsp";
        }else if (selecttotal==3){
            request.getSession().setAttribute("ggg","欢迎下次再来！！！");
            return "f:/jsps/order/msg.jsp";
        }else {
            request.getSession().setAttribute("ggg","GGGGGGGGGGGGGGGG");
            return "f:/jsps/order/msg.jsp";
        }


    }



}
