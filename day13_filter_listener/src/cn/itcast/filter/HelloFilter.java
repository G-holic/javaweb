package cn.itcast.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "HelloListener", urlPatterns = "/hello")
public class HelloFilter implements Filter {
    public HelloFilter() {
        System.out.println("HelloFilter的构造器被执行了。。。");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("HelloFilter正在初始化。。。");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 当前过滤器的核心过滤方法
        System.out.println("访问到了HelloFilter");
        // 目前是没有放行的，此时被过滤器截住了
        filterChain.doFilter(servletRequest,servletResponse); // 放行代码
        System.out.println("这是过滤器放行后的代码");
    }

    @Override
    public void destroy() {
        System.out.println("HelloFilter被销毁了。。。");
    }
}
