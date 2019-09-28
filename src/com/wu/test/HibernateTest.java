package com.wu.test;

import com.wu.dao.UserDao;
import com.wu.domain.User;
import com.wu.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Test
    public void Htest(){

        Session session = sessionFactory.openSession();
        User user = new User();
        user.setUser_name("wuruohui");
        session.save(user);
        session.close();
    }

    @Resource(name = "userDao")
    private UserDao userDao;

    @Resource(name = "userService")
    private UserService userService;
    @Test
    public void fun1(){
        User user = new User();
        user.setUser_name("wuruohui1");
        userService.save(user);
    }
}
