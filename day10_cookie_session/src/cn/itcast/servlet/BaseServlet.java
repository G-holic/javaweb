package cn.itcast.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends ViewBaseServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //1. 获得flag的参数，进行判断
        String flag = request.getParameter("flag");
        //通过反射获得想要调用的方法对象
        Class c = this.getClass();//c就是子类的类信息
        try {
            Method method = c.getDeclaredMethod(flag, HttpServletRequest.class, HttpServletResponse.class);
            //调用这个函数
            method.setAccessible(true);//暴力访问
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
