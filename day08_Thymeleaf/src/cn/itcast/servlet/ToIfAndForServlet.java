package cn.itcast.servlet;

import cn.itcast.bean.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ToIfAndForServlet extends ViewBaseServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("msg", "是共享数据");

        // 简单集合
        List<String> names = new ArrayList<>();
        names.add("java");
        names.add("mysql");
        names.add("oracle");
        names.add("php");
        request.setAttribute("names", names);

        // 复杂集合
        List<Employee> emps = new ArrayList<>();
        emps.add(new Employee(101, "法外狂徒张三", 0, 500000.0));
        emps.add(new Employee(102, "法外狂徒李四", 0, 600000.0));
        emps.add(new Employee(103, "法外狂徒王五", 1, 700000.0));
        request.setAttribute("emps", emps);

        this.processTemplate("ifAndFor", request, response);
    }
}
