package cn.itcast.dao.impl;

import cn.itcast.bean.OrderItem;
import cn.itcast.dao.BaseDaoImpl;
import cn.itcast.dao.OrderItemDao;

public class OrderItemDaoImpl extends BaseDaoImpl implements OrderItemDao {
    @Override
    public void addOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item values(null,?,?,?,?,?,?)";
        this.update(sql,orderItem.getBookName(),orderItem.getPrice(),orderItem.getImgPath(),orderItem.getItemCount(),orderItem.getItemAmount(),orderItem.getOrderId());
    }
}
