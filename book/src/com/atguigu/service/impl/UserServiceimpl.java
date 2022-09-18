package com.atguigu.service.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoimpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;

public class UserServiceimpl implements UserService {

    private UserDao userDao = new UserDaoimpl();
    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username) == null) {
            return false;
        }
        return true;
    }
}
