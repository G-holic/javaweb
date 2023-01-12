package cn.itcast.service;

import cn.itcast.bean.Soldier;

import java.util.List;

public interface SoldierService {
    /**
     * 功能：查询所有的士兵信息
     * @return
     */
    List<Soldier> showAll();

    /**
     * 功能：添加士兵信息
     * @param soldier
     * @return
     */
    boolean saveSoldier(Soldier soldier);

    /**
     * 功能：删除士兵信息
     * @param id
     * @return
     */
    boolean removeSoldier(String id);

    /**
     * 功能：根据id找Soldier对象
     * @param id
     * @return
     */
    Soldier findSoldierById(String id);

    /**
     * 功能：根据id修改对象信息
     * @param soldier
     * @return
     */
    boolean updateSoldier(Soldier soldier);
}
