package cn.itcast.servlet;

import cn.itcast.bean.Soldier;
import cn.itcast.service.SoldierService;
import cn.itcast.service.impl.SoldierServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class UpdateSoldierServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        Map<String, String[]> parameterMap = request.getParameterMap();
        Soldier soldier = new Soldier();
        try {
            BeanUtils.populate(soldier, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        SoldierService soldierService = new SoldierServiceImpl();
        boolean b = soldierService.updateSoldier(soldier);
        if (b) {
            response.sendRedirect(request.getContextPath() + "/showAll");
        }
    }
}
