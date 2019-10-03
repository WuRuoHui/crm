package com.wu.service;

import com.wu.domain.User;
import com.wu.vo.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public interface UserService {
    User getUserByCode(User user);
    void save(User user);

    void saveUser(User user);

    PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

    User getUserById(User user);

    void deleteUserById(User user);
}
