package cn.itcast.dao;

import cn.itcast.bean.Book;

import java.util.List;

public interface BookDao {

    List<Book> findAllBook();


    boolean saveBook(Book book);


    boolean deleteBook(String id);


    Book findBookById(String id);

    boolean updateBook(Book book);

}
