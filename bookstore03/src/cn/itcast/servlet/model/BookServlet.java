package cn.itcast.servlet.model;

import cn.itcast.bean.Book;
import cn.itcast.service.BookService;
import cn.itcast.service.impl.BookServiceImpl;
import cn.itcast.servlet.base.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void findAllBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取请求参数
        // 2.调用业务层处理业务
        List<Book> allBook = bookService.findAllBook();
        request.setAttribute("books", allBook);
        // 3.给响应
        this.processTemplate("manager/book_manager", request, response);
    }

    protected void toAddBookPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 给响应
        this.processTemplate("manager/book_add", request, response);
    }

    protected void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取请求参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        Book book = new Book();
        try {
            BeanUtils.populate(book, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // 2.调用业务层处理业务
        boolean b = bookService.saveBook(book);
        // 3.给响应
        if (b) {
            // 重定向
            // 让浏览器再发一次请求到BookServlet中找findAllBook方法
            response.sendRedirect(request.getContextPath() + "/book?flag=findAllBook");
        }
    }

    protected void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取请求参数（拿取图书id）
        String id = request.getParameter("id");
        boolean b = bookService.deleteBook(id);
        if (b) {
            // 重定向
            // 让浏览器再发一次请求到BookServlet中找findAllBook方法
            response.sendRedirect(request.getContextPath() + "/book?flag=findAllBook");
        }
    }

    protected void toUpdateBookPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取请求参数（拿取图书id）
        String id = request.getParameter("id");
        Book bookById = bookService.findBookById(id);
        request.setAttribute("book", bookById);
        this.processTemplate("manager/book_edit", request, response);
    }


    protected void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Book book = new Book();
        try {
            BeanUtils.populate(book,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        boolean b = bookService.updateBook(book);
        if (b){
            // 重定向
            // 让浏览器再发一次请求到BookServlet中找findAllBook方法
            response.sendRedirect(request.getContextPath() + "/book?flag=findAllBook");
        }
    }
}
