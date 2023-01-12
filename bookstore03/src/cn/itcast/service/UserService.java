package cn.itcast.service;

import cn.itcast.bean.User;

public interface UserService {
    /**
     * 功能：注册
     * @param user
     * @return
     */
    boolean regist(User user);

    /**
     * 功能：登陆
     * @param username
     * @param password
     * @return
     */
    User login(String username,String password);
}
