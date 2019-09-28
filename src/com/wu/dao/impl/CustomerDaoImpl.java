package com.wu.dao.impl;

import com.wu.dao.CustomerDao;
import com.wu.domain.Customer;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {
//    @Override
//    public Integer getTotalCount(DetachedCriteria dc) {
//        dc.setProjection(Projections.rowCount());
//        List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
//        dc.setProjection(null);
//        if (list != null && list.size() > 0) {
//            return list.get(0).intValue();
//        } else {
//            return null;
//        }
//    }

//    @Override
//    public List<Customer> getPageList(DetachedCriteria dc, int start, int pageSize) {
//        List<Customer> customerList = (List<Customer>) getHibernateTemplate().findByCriteria(dc, start, pageSize);
//        return customerList;
//    }
}
