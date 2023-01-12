package cn.itcast.servlet;

import cn.itcast.bean.Soldier;
import cn.itcast.service.SoldierService;
import cn.itcast.service.impl.SoldierServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ToUpdateSoldierPageServlet extends ViewBaseServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SoldierService soldierService = new SoldierServiceImpl();
        Soldier soldierById = soldierService.findSoldierById(id);
        request.setAttribute("soldier", soldierById);
        this.processTemplate("updateSoldier", request, response);
    }
}
