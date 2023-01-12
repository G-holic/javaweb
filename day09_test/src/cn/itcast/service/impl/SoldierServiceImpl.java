package cn.itcast.service.impl;

import cn.itcast.bean.Soldier;
import cn.itcast.dao.BaseDaoImpl;
import cn.itcast.dao.SoliderDao;
import cn.itcast.dao.impl.SoliderDaoImpl;
import cn.itcast.service.SoldierService;

import java.util.List;

public class SoldierServiceImpl extends BaseDaoImpl implements SoldierService {
    private SoliderDao soliderDao = new SoliderDaoImpl();

    @Override
    public List<Soldier> showAll() {
        return soliderDao.findAll();
    }

    @Override
    public boolean saveSoldier(Soldier soldier) {
        return soliderDao.addSoldier(soldier);
    }

    @Override
    public boolean removeSoldier(String id) {
        return soliderDao.removeSoldier(id);
    }

    @Override
    public Soldier findSoldierById(String id) {
        return soliderDao.findSoldierById(id);
    }

    @Override
    public boolean updateSoldier(Soldier soldier) {
        return soliderDao.updateSoldier(soldier);
    }
}
