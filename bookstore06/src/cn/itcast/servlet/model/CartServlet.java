package cn.itcast.servlet.model;

import cn.itcast.bean.Book;
import cn.itcast.bean.Cart;
import cn.itcast.bean.CartItem;
import cn.itcast.service.BookService;
import cn.itcast.service.impl.BookServiceImpl;
import cn.itcast.servlet.base.BaseServlet;
import cn.itcast.util.CommonResult;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CartServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理加入购物车的请求
        // 1.获得请求参数
        // 获得图书的id值
        String id = request.getParameter("id");
        System.out.println("id = " + id);
        // 获得购物车的对象(到底有没有购物车对象-->去session中获取)
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");// 这个key值，暂时不能确定
        if (cart == null) {
            // cart如果是null，说明session中没有cart对象，新建一个cart对象
            cart = new Cart();
            // 新建完后，将对象存储在session中
            session.setAttribute("cart", cart);
        }
        // 结论：程序跑到此处，cart就是购物车对象

        // 2.处理业务(不连接数据库，所以没有service)
        // 根据图书的id查到图书的信息
        Book bookById = bookService.findBookById(id);
        // 应该将图书对象，传递到Cart类中，去判断map集合中是否有这本书的信息
        cart.addCart(bookById);
        // 3.给响应
        // 响应内容添加一个总数量（获得总数量）
        Integer totalCount = cart.getTotalCount();
        CommonResult ok = CommonResult.ok().setResultData(totalCount);
        String s = new Gson().toJson(ok);
        System.out.println("s = " + s);//{flag:true,resultData:数量}
        response.getWriter().write(s);
    }

    protected void toCartPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 将页面跳转设置到cart.html
        this.processTemplate("cart/cart", request, response);
    }

    protected void showCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获得到购物车的所有数据，然后响应给js
        // 1. n个购物项  2.总数量  3.总金额
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        // 拿到的是Map集合中所有的value值！为什么不直接将Map集合返回拿到呢？ 因为要直接遍历
        Collection<CartItem> allCartItem = cart.getAllCartItem();
        Integer totalCount = cart.getTotalCount();
        Double totalAmount = cart.getTotalAmount();
        // 2.需要将这些数据变为json字符串，返回给js
        List list = new ArrayList();
        list.add(allCartItem);
        list.add(totalCount);
        list.add(totalAmount);
        CommonResult commonResult = CommonResult.ok().setResultData(list);
        String s = new Gson().toJson(commonResult);
        System.out.println("s = " + s);//该字符串就比较复杂了
        // {flag:true,resultData:[[{购物项},{购物项},{购物项}],5,500]}
        // 这边需要将数据写回去
        response.getWriter().write(s);
    }

    protected void clearCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("cart");
        // 将页面跳转设置到cart.html
        this.processTemplate("cart/cart", request, response);
    }

    protected void deleteCartItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获得请求参数
        String id = request.getParameter("id");
        // 2.获得购物车对象
        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        // 3.调用cart中的方法删除购物项
        cart.deleteCartItem(Integer.parseInt(id));
        // 4.后台的数据删除成功了，前台怎么办？因为是异步请求，前台是不刷新的
        // 调用showCart把前台数据刷新一下
        showCart(request,response);
    }

    protected void addCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获得请求参数
        String id = request.getParameter("id");
        // 2.获得购物车对象
        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        // 3.调用cart对象中的方法，对购物项的数量进行加一操作
        cart.addCount(Integer.parseInt(id));
        // 4.后台的数据已经刷新完毕，前台怎么办
        // 调用showCart把前台数据刷新一下
        showCart(request,response);
    }


    protected void subtractCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获得请求参数
        String id = request.getParameter("id");
        // 2.获得购物车对象
        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        // 3.调用cart对象中的方法，对购物项的数量进行减一操作
        cart.subtractCount(Integer.parseInt(id));
        // 4.后台的数据已经刷新完毕，前台怎么办
        // 调用showCart把前台数据刷新一下
        showCart(request,response);
    }

    protected void changeCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获得请求参数
        String id = request.getParameter("id");
        String newCount = request.getParameter("newCount");
        // 2.获得购物车对象
        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        // 3.调用cart对象中的方法，对购物项的数量进行修改操作
        cart.changeCount(Integer.parseInt(id),Integer.parseInt(newCount));
        // 4.后台的数据已经刷新完毕，前台怎么办
        // 调用showCart把前台数据刷新一下
        showCart(request,response);
    }
}
