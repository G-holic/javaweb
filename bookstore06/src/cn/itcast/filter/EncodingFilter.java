package cn.itcast.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter", urlPatterns = "/*")
public class EncodingFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");// 处理post请求乱码
        resp.setContentType("text/html;charset=utf-8");// 处理响应乱码
        chain.doFilter(req, resp);// 100%放行
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

}
