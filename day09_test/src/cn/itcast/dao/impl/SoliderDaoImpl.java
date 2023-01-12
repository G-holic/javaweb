package cn.itcast.dao.impl;

import cn.itcast.bean.Soldier;
import cn.itcast.dao.BaseDaoImpl;
import cn.itcast.dao.SoliderDao;

import java.util.List;

public class SoliderDaoImpl extends BaseDaoImpl implements SoliderDao {
    @Override
    public List<Soldier> findAll() {
        String sql = "SELECT soldier_id soldierid,soldier_name soldiername,soldier_weapon soldierweapon FROM t_soldier";
        return this.getList(Soldier.class, sql);
    }

    @Override
    public boolean addSoldier(Soldier soldier) {
        String sql = "insert into t_soldier values(null,?,?)";
        return this.update(sql, soldier.getSoldierName(), soldier.getSoldierWeapon()) > 0;
    }

    @Override
    public boolean removeSoldier(String id) {
        String sql = "delete from t_soldier where soldier_id=?";
        return this.update(sql, id) > 0;
    }

    @Override
    public Soldier findSoldierById(String id) {
        String sql = "SELECT soldier_id soldierid,soldier_name soldiername,soldier_weapon soldierweapon FROM t_soldier where soldier_id = ?";
        return this.getBean(Soldier.class, sql, id);
    }

    @Override
    public boolean updateSoldier(Soldier soldier) {
        String sql = "update t_soldier set soldier_name=?,soldier_weapon=? where soldier_id=?";
        return this.update(sql, soldier.getSoldierName(), soldier.getSoldierWeapon(), soldier.getSoldierId()) > 0;
    }
}
