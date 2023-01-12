package cn.itcast.dao;

import cn.itcast.bean.User;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {

    @Override
    public boolean addUser(User user) {
        String sql = "insert into users values(null,?,?,?)";
        int update = this.update(sql, user.getUsername(), user.getPassword(), user.getEmail());
        if (update > 0) {
            return true;
        }
        return false;
    }

    @Override
    public User findUserByUsername(String username) {
        String sql = "select * from users where username=?";
        return this.getBean(User.class, sql, username);
    }
}
