package cn.itcast.bean;

import java.math.BigDecimal;
import java.text.CollationKey;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    // n个购物项（Map集合或者List集合）
    private Map<Integer, CartItem> map = new HashMap(); // 将书的id作为map的key值
    private Integer totalCount; // 购物车的总数量（可以通过map集合运算得到）
    private Double totalAmount; // 购物车的总金额（可以通过map集合运算得到）


    /**
     * 功能：将这本书添加到购物车
     *
     * @param book
     */
    public void addCart(Book book) {
        // 判断这本书在map集合中是否存在
        CartItem cartItem = map.get(book.getBookId());
        if (cartItem == null) {
            //说明这本书没有添加过，本次是第一次添加，新建cartItem对象，数量设置为1
            CartItem item = new CartItem(book, 1);
            map.put(book.getBookId(), item);
        } else {
            // 说明之前添加过，cartItem就是那个购物项的对象，将count+1
            cartItem.setCount(cartItem.getCount() + 1);
        }

        System.out.println(map);// 就是为了查看添加是否成功
    }

    /**
     * 计算购物车的书总数量
     *
     * @return
     */
    public Integer getTotalCount() {
        Collection<CartItem> values = map.values();
        Integer total = 0;
        for (CartItem value : values) {
            total += value.getCount();
        }
        this.totalCount = total;
        return totalCount;
    }

    /**
     * 计算总金额
     *
     * @return
     */
    public Double getTotalAmount() {
        Collection<CartItem> values = map.values();
        BigDecimal total = new BigDecimal("0");
        for (CartItem value : values) {
            BigDecimal amount = new BigDecimal(value.getAmount()+"");
            // 将amount累加到total上
            total=total.add(amount);
        }
        this.totalAmount = total.doubleValue();
        return totalAmount;
    }

    /**
     * 拿到所有的购物项
     *
     * @return
     */
    public Collection<CartItem> getAllCartItem() {
        return map.values();
    }

    /**
     * 删除购物项
     *
     * @param id
     */
    public void deleteCartItem(Integer id) {
        map.remove(id);
    }

    /**
     * 对购物项的数量进行加一操作
     *
     * @param id
     */
    public void addCount(Integer id) {
        CartItem item = map.get(id);
        item.setCount(item.getCount() + 1);
    }

    /**
     * 购物项的数量进行减一操作
     * @param id
     */
    public void subtractCount(Integer id) {
        CartItem item = map.get(id);
        if (item.getCount() > 1) {
            item.setCount(item.getCount() - 1);
        }else {
            deleteCartItem(id);
        }
        // 前端处理
//        CartItem item = map.get(id);
//        item.setCount(item.getCount() - 1);
    }

    /**
     * 购物项的数量进行修改操作
     * @param id
     * @param newCount
     */
    public void changeCount(Integer id,Integer newCount){
        CartItem item = map.get(id);
        item.setCount(newCount);
    }
}
