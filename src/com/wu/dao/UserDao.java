package com.wu.dao;

import com.wu.domain.User;

public interface UserDao extends BaseDao<User>{

    User getByUserCode(String user_code);

}
