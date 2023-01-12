package cn.itcast.dao;

import cn.itcast.bean.Order;

import java.util.List;

public interface OrderDao {
    /**
     * 功能：添加订单信息
     * @param order
     */
    void addOrder(Order order);

    /**
     * 功能：根据订单编号查找订单ID
     * @param orderSequence
     * @return
     */
    Integer findIdBySequence(String orderSequence);

    List<Order> findAllOrder(Integer userId);
}
