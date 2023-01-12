package cn.itcast.service;

import cn.itcast.bean.Cart;
import cn.itcast.bean.Order;
import cn.itcast.bean.User;

import java.util.List;

public interface OrderService {
    // 处理创建订单的业务
    String createOrder(Cart cart, User user);

    // 根据用户查找所有的订单信息
    List<Order> findAllOrder(Integer userId);
}
