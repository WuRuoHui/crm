package com.wu.dao.impl;

import com.wu.dao.CustomerDao;
import com.wu.domain.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;

import java.util.List;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

    @Override
    public List<Object> getIndustryCount() {
        List<Object> l = getHibernateTemplate().execute(new HibernateCallback<List<Object>>() {

            @Override
            public List<Object> doInHibernate(Session session) throws HibernateException {
                String sql = "select bd.dict_item_name,count(*) from base_dict bd,cst_customer c where bd.dict_id = c.cust_industry group by cust_industry";
                List<Object> list = session.createSQLQuery(sql).list();
                return list;
            }
        });
        return l;
    }
}
