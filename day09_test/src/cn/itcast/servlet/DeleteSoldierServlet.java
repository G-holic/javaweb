package cn.itcast.servlet;

import cn.itcast.bean.Soldier;
import cn.itcast.service.SoldierService;
import cn.itcast.service.impl.SoldierServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteSoldierServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.调用请求参数
        String id = request.getParameter("id");
        // 2.调用业务层处理业务
        SoldierService soldierService = new SoldierServiceImpl();
        boolean b = soldierService.removeSoldier(id);
        // 3.给响应
        if(b){
            response.sendRedirect(request.getContextPath()+"/showAll");
        }
    }
}
