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

public class AddSoldierServlet extends ViewBaseServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理乱码
        request.setCharacterEncoding("utf-8");
        // 1.获取请求参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        Soldier soldier = new Soldier();
        try {
            BeanUtils.populate(soldier,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // 2.调用业务层处理业务
        SoldierService soldierService = new SoldierServiceImpl();
        boolean b = soldierService.saveSoldier(soldier);
        // 3.给响应（添加完后应该去到哪里？士兵展示页面）
        if (b){
//            this.processTemplate("showAllSoldier",request,response);
            // 在执行一次ShowAllSoldierServlet
//            request.getRequestDispatcher("/showAll").forward(request,response); // 转发的话，网址不变，怕刷新
            // 建议使用重定向
            response.sendRedirect(request.getContextPath()+"/showAll");
        }

    }
}
