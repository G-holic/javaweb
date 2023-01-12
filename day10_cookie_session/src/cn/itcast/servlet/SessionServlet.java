package cn.itcast.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends BaseServlet {
    protected void createSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获得session对象
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(40);// 单位是秒（设置session对象的有效时间）
        System.out.println("session = " + session);
    }

    protected void addValueSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 往session对象中设置共享数据
        HttpSession session = request.getSession();
        System.out.println("session = " + session);
        session.setAttribute("sessionMsg", "sessionValue");
    }


    protected void getValueSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从session对象中获取共享数据
        HttpSession session = request.getSession();
        System.out.println("session = " + session);
        Object sessionMsg = session.getAttribute("sessionMsg");
        System.out.println("sessionMsg = " + sessionMsg);
    }


    protected void removeValueSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从session对象中移除共享数据
        HttpSession session = request.getSession();
        System.out.println("session = " + session);
        session.removeAttribute("sessionMsg");
    }


    protected void removeSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 销毁session对象
        HttpSession session = request.getSession();
        System.out.println("session = " + session);
        session.invalidate();// 强制失效
    }
}
