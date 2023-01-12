package cn.itcast.servlet;

import cn.itcast.bean.Soldier;
import cn.itcast.service.SoldierService;
import cn.itcast.service.impl.SoldierServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowAllSoldierServlet extends ViewBaseServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获得请求参数
        // 2.调用业务层处理业务
        SoldierService soldierService = new SoldierServiceImpl();
        List<Soldier> soldiers = soldierService.showAll();

        // 3.给响应
        request.setAttribute("soldiers",soldiers);
        this.processTemplate("showAllSoldier", request, response);
    }
}
