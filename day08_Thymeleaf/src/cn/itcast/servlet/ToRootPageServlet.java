package cn.itcast.servlet;

import cn.itcast.bean.Computer;
import cn.itcast.bean.Employee;
import cn.itcast.bean.Employee02;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToRootPageServlet extends ViewBaseServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 往请求域内共享一个简单对象
        Employee employee = new Employee(101, "法外狂徒张三", 0, 50000.0);
        request.setAttribute("emp", employee);

        // 往请求域内共享一个复杂对象
        Employee02 employee02 = new Employee02(102, "法外狂徒李四", 1, 341251d, new Computer(1, "联想", 5000d));
        request.setAttribute("emp02", employee02);

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

        Map<String, Employee> map = new HashMap<>();
        map.put("emp01", new Employee(101, "jack", 0, 500000.0));
        map.put("emp02", new Employee(102, "rose", 0, 600000.0));
        map.put("emp03", new Employee(103, "holic", 1, 700000.0));
        request.setAttribute("map", map);

        this.processTemplate("root", request, response);
    }
}
