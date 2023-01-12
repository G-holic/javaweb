package cn.itcast.filter;

import cn.itcast.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = "/order")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 处于登录状态放行，不处于登录状态让页面跳转至登录页面
        // 如何验证是否处于登录状态，查看session中是否存在User对象
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        User user = (User)request.getSession().getAttribute("user");
        if (user==null){
            // 说明不处于登录状态，页面跳转至登录页面(如何跳转)
            // 重定向过去即可
            response.sendRedirect(request.getContextPath()+"/user?flag=toLoginPage");
        }else {
            // 说明处于登录状态
            chain.doFilter(req, resp);//放行的代码
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
