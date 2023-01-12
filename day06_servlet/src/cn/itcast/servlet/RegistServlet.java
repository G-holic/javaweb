package cn.itcast.servlet;

import cn.itcast.bean.User;
import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class RegistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获得请求参数
        /*String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        User user = new User(0, username, password, email);*/

        Map<String, String[]> parameterMap = req.getParameterMap(); //map集合中的key值是什么？表单的name属性值
        User user = new User();
        // BeanUtils的使用
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("user = " + user);
        // 2.处理注册的业务 // 3.给响应
        UserDao userDao = new UserDaoImpl();
        User userByUsername = userDao.findUserByUsername(user.getUsername());
        if (userByUsername == null) {
            // 可以注册
            userDao.addUser(user);
            req.getRequestDispatcher("regist_success.html").forward(req, resp);
        } else {
            // 注册失败
            req.getRequestDispatcher("regist_error.html").forward(req, resp);
        }

    }
}
