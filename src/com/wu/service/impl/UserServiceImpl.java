package com.wu.service.impl;

import com.wu.dao.UserDao;
import com.wu.domain.User;
import com.wu.service.UserService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(isolation = Isolation.REPEATABLE_READ, readOnly = true, propagation = Propagation.REQUIRED)
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
    @Transactional(isolation = Isolation.REPEATABLE_READ, readOnly = false, propagation = Propagation.REQUIRED)
    public void save(User user) {
        userDao.save(user);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
