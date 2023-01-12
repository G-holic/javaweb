package cn.itcast.servlet.model;

import cn.itcast.bean.User;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;
import cn.itcast.servlet.base.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class UserServlet extends BaseServlet {
    protected void toRegistPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.processTemplate("user/regist", request, response);
    }

    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获得请求参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();

        try {
            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // 2.处理注册的业务（暂时不考虑用户名重复的问题）
        // 将信息添加到数据库即可（密码的加密问题）
        UserService userService = new UserServiceImpl();
        boolean b = userService.regist(user);

        // 3.给响应（页面跳转）
        if (b) {
            request.setAttribute("username", user.getUsername());
            this.processTemplate("user/regist_success", request, response);
        } // 目前不考虑注册失败的情况
    }

    protected void toLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.processTemplate("user/login", request, response);
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获得参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //2. 调用业务层进行业务处理
        UserService userService = new UserServiceImpl();
        User login = userService.login(username, password);
        //3. 给响应
        if (login == null) {
            //登录失败：用户名的回显、错误信息的提示
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("errMsg", "用户名或密码错误");
            this.processTemplate("user/login", request, response);
        } else {
            request.setAttribute("user", login);
            this.processTemplate("user/login_success", request, response);
        }
    }
}
