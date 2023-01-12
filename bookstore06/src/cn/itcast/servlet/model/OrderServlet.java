package cn.itcast.servlet.model;

import cn.itcast.bean.Cart;
import cn.itcast.bean.Order;
import cn.itcast.bean.User;
import cn.itcast.service.OrderService;
import cn.itcast.service.impl.OrderServiceImpl;
import cn.itcast.servlet.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderServlet", value = "/order")
public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();
    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理结账的请求
        // 1.获得请求参数（获得结账相关的数据）
            // 购物车（n个购物项，总数量，总金额）
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
            // 当前登录人的信息手动保持一点，登陆后再点击去结账）
        User user = (User) session.getAttribute("user");// 如果没有登陆，user就是null

        // 2.调用业务层梳理业务
            // 订单的保存、订单项的保存，这些操作是在servlet内事项吗？不是的，业务层就是专门处理业务的
        String orderSequence = orderService.createOrder(cart, user);
        // 结账时把购物车清空一下
        session.removeAttribute("cart");
        // 3.给响应
        // 需要将订单号，放在请求域，转发到网页，听过thymeleaf渲染
        request.setAttribute("orderSequence",orderSequence);
        this.processTemplate("cart/checkout",request,response);
    }


    protected void showOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获得当前登录人的对象（根据当前登录人的id值进行数据查询）  先登录-->点击我的订单
        User user = (User)request.getSession().getAttribute("user");
        // 2.调用业务层处理业务
        List<Order> allOrder = orderService.findAllOrder(user.getId());
        // 3.给响应
        request.setAttribute("orders",allOrder);
        this.processTemplate("order/order",request,response);
    }
}
