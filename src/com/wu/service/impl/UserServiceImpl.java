package com.wu.service.impl;

import com.wu.dao.UserDao;
import com.wu.domain.User;
import com.wu.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Override
    public User getUserByCode(User user) {
        User exitU = userDao.getByUserCode(user.getUser_code());
        if (exitU == null || !exitU.getUser_password().equals(user.getUser_password())) {
            throw new RuntimeException("用户名或者密码错误");
        }
        return exitU;
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void saveUser(User user) {
        User isExitU = userDao.getByUserCode(user.getUser_code());
        if (isExitU != null) {
            throw new RuntimeException("用户名已存在");
        }
        userDao.save(user);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
