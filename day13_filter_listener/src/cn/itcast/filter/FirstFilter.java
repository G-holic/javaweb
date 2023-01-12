package cn.itcast.filter;

import javax.servlet.*;
import java.io.IOException;

public class FirstFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("这是FirstFilter放行前代码。。。");
        chain.doFilter(req, resp);// 放行代码
        System.out.println("这是FirstFilter放行后代码。。。");
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

}
