package cn.itcast.bean;

import java.math.BigDecimal;

/**
 * 购物项的类
 */
public class CartItem {
    private Book book; // 书的图片、名字、单价book对象内都存在
    private Integer count; // 这本书在购物车中的数量
    private Double amount; // 这本书在购物车中的金额（可以通过运算算出来的book.getPrice*count）

    public CartItem() {
    }

    public CartItem(Book book, Integer count) {
        this.book = book;
        this.count = count;
//        this.amount = amount;
        // 有参构造器，计算amount
        BigDecimal price = new BigDecimal(this.book.getPrice()+"");// 使用字符串的构造器
        BigDecimal count1 = new BigDecimal(this.count+"");
        this.amount = price.multiply(count1).doubleValue();
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
        // 设置图书的时候，计算金额
        BigDecimal price = new BigDecimal(this.book.getPrice()+"");// 使用字符串的构造器
        BigDecimal count = new BigDecimal(this.count+"");
        this.amount = price.multiply(count).doubleValue();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
        // 设置数量，将amount算出来
        BigDecimal price = new BigDecimal(this.book.getPrice()+"");// 使用字符串的构造器
        BigDecimal count1 = new BigDecimal(this.count+"");
        this.amount = price.multiply(count1).doubleValue();
    }

    public Double getAmount() {
        return amount;
    }

    // 不需要setAmount
//    public void setAmount(Double amount) {
//        this.amount = amount;
//    }

    @Override
    public String toString() {
        return "CartItem{" +
                "book=" + book +
                ", count=" + count +
                ", amount=" + amount +
                '}';
    }
}
