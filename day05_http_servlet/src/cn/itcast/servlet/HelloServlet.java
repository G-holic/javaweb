package cn.itcast.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("HelloServlet的构造器被执行了");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("HelloServlet的init被执行了");
        String servletName = servletConfig.getServletName();
        System.out.println("servletName = " + servletName);// servletName = abc

        ServletContext servletContext = servletConfig.getServletContext();
        System.out.println("servletContext = " + servletContext);// servletContext = org.apache.catalina.core.ApplicationContextFacade@275c92c5

        // 3. 获得当前Servlet的初始化参数
        // 如何设置当前Servlet的的初始化参数
        // 位置： web.xml
        String path = servletConfig.getInitParameter("path");
        System.out.println("path = " + path);// path = classpath:springmvc.xml

        String aaa = servletConfig.getInitParameter("aaa");
        System.out.println("aaa = " + aaa);// aaa = bbb

        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String s = initParameterNames.nextElement();
            System.out.println("s = " + s);// s = aaa   s = path
        }
    }

    /**
     * 主要功能：处理客户端的请求和响应
     * @param servletRequest   处理请求
     * @param servletResponse   处理响应
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("访问到了HelloServlet的service方法.....");

        ServletContext servletContext = servletRequest.getServletContext();
        System.out.println("servletContext = " + servletContext);// servletContext = org.apache.catalina.core.ApplicationContextFacade@64e4e2b5

        // ServletContext 的功能
        // 获取项目的上下文路径（带/的项目名）
        String contextPath = servletContext.getContextPath();
        System.out.println("contextPath = " + contextPath);// contextPath = /day05_http_servlet_war_exploded
        // 获取细腻路径所映射的本地真实路径（工具相对路径获得）
        String realPath = servletContext.getRealPath("/upload");
        System.out.println("realPath = " + realPath);
        // 获取WEB应用程序的全局初始化参数
           // 如何设置全局初始化参数
           // 位置：web.xml的根节点下
        String servletContextInitParamKey = servletContext.getInitParameter("servletContextInitParamKey");
        System.out.println(servletContextInitParamKey); // servletContextInitParamValue

        String ccc = servletContext.getInitParameter("ccc");
        System.out.println("ccc = " + ccc);// ccc = ddd

        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String s = initParameterNames.nextElement();
            System.out.println("s = " + s);// s = ccc   s = servletContextInitParamKey
        }
        // 作为域对象共享数据（MyFirstServlet）
            // 域对象：在一定的作用域范围内共享的对象
            // ServletContext作用域是整个web项目



    }

    @Override
    public void destroy() {
        System.out.println("HelloServlet的destroy被执行了");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
}
