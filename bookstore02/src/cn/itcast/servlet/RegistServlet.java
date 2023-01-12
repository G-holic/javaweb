package cn.itcast.servlet;

import cn.itcast.bean.User;
import cn.itcast.dao.UserDaoImpl;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;
import cn.itcast.util.MD5Util;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        /*UserDaoImpl userDao = new UserDaoImpl();
        String encode = MD5Util.encode((user.getPassword()));
        user.setPassword(encode);
        boolean b = userDao.addUser(user);*/
        UserService userService = new UserServiceImpl();
        boolean b = userService.regist(user);

        // 3.给响应（页面跳转）
        if (b) {
            request.getRequestDispatcher("/pages/user/regist_success.html").forward(request, response);
        } else {
            request.getRequestDispatcher("/pages/user/regist.html").forward(request, response);

        }

    }
}
