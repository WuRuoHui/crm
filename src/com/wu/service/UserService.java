package com.wu.service;

import com.wu.domain.User;

public interface UserService {
    User getUserByCode(User user);
    void save(User user);

    void saveUser(User user);
}
