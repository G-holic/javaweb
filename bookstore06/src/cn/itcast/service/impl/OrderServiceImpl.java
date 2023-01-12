package cn.itcast.service.impl;

import cn.itcast.bean.*;
import cn.itcast.dao.BookDao;
import cn.itcast.dao.OrderDao;
import cn.itcast.dao.OrderItemDao;
import cn.itcast.dao.impl.BookDaoImpl;
import cn.itcast.dao.impl.OrderDaoImpl;
import cn.itcast.dao.impl.OrderItemDaoImpl;
import cn.itcast.service.OrderService;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, User user) { // 需要把这个整体看作一个事务

        // 1.创建订单信息并保存到数据库
        String orderSequence = "SGG" + System.currentTimeMillis();// 订单编号
        Date date = new Date();
        // 对当前系统时间进行格式化
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        Order order = new Order(null, orderSequence, format, cart.getTotalCount(), cart.getTotalAmount(), 0, user.getId());
        // 调用dao层，将order的数据添加到数据库内
        orderDao.addOrder(order);
        // 2.创建n个订单项信息并保存到数据库（订单项是有很多个  1.批处理  2.循环）（这里采用循环：好理解）
        // 通过循环的方式去实现
        // 订单id是根据订单编号去查询（框架阶段，是可以在新增的时候，公会自增的id的）
        Integer idBySequence = orderDao.findIdBySequence(orderSequence);
        Collection<CartItem> allCartItem = cart.getAllCartItem();

        // 假设出现了异常
//        int i = 10/0;//存在异常（去结账，数据库应该毫无变化才是正常的）
        // 没有异常，应该是正常添加
        for (CartItem item : allCartItem) {
            // 一个item（购物项）对应一个订单项（orderItem对象）
            OrderItem orderItem = new OrderItem(null, item.getBook().getBookName(), item.getBook().getPrice(), item.getBook().getImgPath(), item.getCount(), item.getAmount(), idBySequence);
            // 调用dao层， 将orderItem的数据保存到数据库
            orderItemDao.addOrderItem(orderItem);
            // 3.对图书的库存和销量进行修改操作（暂时不考虑库存不足的情况）
            // 每一个订单项的生成都随之改变当前书的库存和销量
            Book book = item.getBook();// 这就是需要修改信息的那本书
            book.setSales(book.getSales()+item.getCount());// 销量
            book.setStock(book.getStock()-item.getCount());// 库存
            bookDao.updateBook(book);// 根据书的id修改其他信息
        }


        return orderSequence;// 需要把订单号返回给Servlet
    }

    @Override
    public List<Order> findAllOrder(Integer userId) {
        return orderDao.findAllOrder(userId);
    }
}
