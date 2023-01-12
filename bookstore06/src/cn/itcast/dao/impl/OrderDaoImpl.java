package cn.itcast.dao.impl;

import cn.itcast.bean.Order;
import cn.itcast.dao.BaseDaoImpl;
import cn.itcast.dao.OrderDao;

import java.util.List;

public class OrderDaoImpl extends BaseDaoImpl implements OrderDao {
    @Override
    public void addOrder(Order order) {
        String sql = "insert into t_order values(null,?,?,?,?,?,?)";
        this.update(sql, order.getOrderSequence(), order.getCreateTime(), order.getTotalCount(), order.getTotalAmount(), order.getOrderStatus(), order.getUserId());
    }

    @Override
    public Integer findIdBySequence(String orderSequence) {
        String sql = "select order_id from t_order where  order_sequence= ?";
        return (Integer) this.getValue(sql,orderSequence);
    }

    @Override
    public List<Order> findAllOrder(Integer userId) {
        String sql = "select order_id orderId,order_sequence orderSequence, create_time createTime, total_count totalCount,total_amount totalAmount,order_status orderStatus,user_id userId from t_order where user_id = ?";
        return this.getList(Order.class,sql,userId);
    }
}
