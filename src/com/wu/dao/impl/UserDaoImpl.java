package com.wu.dao.impl;

import com.wu.dao.UserDao;
import com.wu.domain.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    @Override
    public User getByUserCode(final String user_code) {
        return getHibernateTemplate().execute(new HibernateCallback<User>() {
            @Override
            public User doInHibernate(Session session) throws HibernateException {
                String hql = "from User where user_code = ?";
                Query query = session.createQuery(hql);
                query.setParameter(0, user_code);
                User user = (User) query.uniqueResult();
                return user;
            }
        });
//        DetachedCriteria dc = DetachedCriteria.forClass(User.class);
//        dc.add(Restrictions.eq("user_code", user_code));
//        List<User> user = (List<User>) getHibernateTemplate().findByCriteria(dc);
//        if (user != null && user.size() > 0) {
//            return user.get(0);
//        } else {
//            return null;
//        }
    }

//    @Override
//    public void save(User user) {
//        getHibernateTemplate().save(user);
//    }
}
