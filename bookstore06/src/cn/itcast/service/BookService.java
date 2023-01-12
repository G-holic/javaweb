package cn.itcast.service;

import cn.itcast.bean.Book;

import java.util.List;

public interface BookService {
    /**
     * 功能：查询所有图书
     * @return
     */
    List<Book> findAllBook();

    /**
     * 功能：添加图书
     * @param book
     * @return
     */
    boolean saveBook(Book book);

    /**
     * 功能：根据id删除图书
     * @param id
     * @return
     */
    boolean deleteBook(String id);

    /**
     * 功能：根据id查找图书信息
     * @param id
     * @return
     */
    Book findBookById(String id);

    /**
     * 功能：根据书的id修改图书信息
     * @param book
     * @return
     */
    boolean updateBook(Book book);
}
