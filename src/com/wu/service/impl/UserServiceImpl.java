package com.wu.service.impl;

import com.wu.dao.UserDao;
import com.wu.domain.User;
import com.wu.service.UserService;
import com.wu.utils.MD5Utils;
import com.wu.vo.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Override
    public User getUserByCode(User user) {
        User exitU = userDao.getByUserCode(user.getUser_code());
        if (exitU == null || !exitU.getUser_password().equals(MD5Utils.md5(user.getUser_password()))) {
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
        user.setUser_password(MD5Utils.md5(user.getUser_password()));
        userDao.save(user);
    }

    @Override
    public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
        Integer totalCount = userDao.getTotalCount(dc);
        PageBean pageBean = new PageBean(currentPage,totalCount,pageSize);
        List<User> userList = userDao.getPageList(dc,pageBean.getStart(),pageBean.getPageSize());
        pageBean.setList(userList);
        return pageBean;
    }

    @Override
    public User getUserById(User user) {
        return userDao.getById(user.getUser_id());
    }

    @Override
    public void deleteUserById(User user) {
        userDao.delete(user.getUser_id());
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
