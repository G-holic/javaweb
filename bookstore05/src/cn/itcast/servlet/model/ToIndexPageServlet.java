package cn.itcast.servlet.model;

import cn.itcast.bean.Book;
import cn.itcast.service.impl.BookServiceImpl;
import cn.itcast.servlet.base.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ToIndexPageServlet extends ViewBaseServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.查到所有图书数据
        BookServiceImpl bookService = new BookServiceImpl();
        List<Book> allBook = bookService.findAllBook();
        // 2.放在请求域中
        request.setAttribute("books",allBook);
        this.processTemplate("index", request, response);
    }
}
