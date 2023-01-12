package cn.itcast.service.impl;

import cn.itcast.bean.User;
import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.service.UserService;
import cn.itcast.util.MD5Util;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public boolean regist(User user) {
        // 1.加密
        user.setPassword(MD5Util.encode(user.getPassword()));
        // 2.保存
        return userDao.addUser(user);
    }

    @Override
    public User login(String username, String password) {
        // 1.先根据用户名查看User对象
        User userByUsername = userDao.findUserByUsername(username);
        // 2.如果找到，再验证密码是否正确（密码先加密后再验证）
        if (userByUsername!=null){
            String encode = MD5Util.encode(password);
            if (encode.equals(userByUsername.getPassword())){
                return userByUsername;
            }
        }
        return null;
    }
}
