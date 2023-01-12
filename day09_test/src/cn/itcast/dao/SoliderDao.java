package cn.itcast.dao;

import cn.itcast.bean.Soldier;

import java.util.List;

public interface SoliderDao {

    List<Soldier> findAll();

    boolean addSoldier(Soldier soldier);

    boolean removeSoldier(String id);

    Soldier findSoldierById(String id);
    boolean updateSoldier(Soldier soldier);

}
