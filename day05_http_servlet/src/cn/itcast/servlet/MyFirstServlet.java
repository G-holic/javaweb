package cn.itcast.servlet;

import javax.servlet.*;
import java.io.IOException;

public class MyFirstServlet extends GenericServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("访问到了MyFirstServlet中的service方法.....");

        ServletContext servletContext = servletRequest.getServletContext();
        System.out.println("servletContext = " + servletContext);

        // 如何往ServletContext作用域对象中设置共享数据
        servletContext.setAttribute("msg","这是MyFirstServlet的共享数据");

//        servletContext.removeAttribute("msg");// 移除共享数据
    }
}
