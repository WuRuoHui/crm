package com.wu.service;

import com.wu.domain.Customer;
import com.wu.vo.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public interface CustomerService {
    PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

    void save(Customer customer);

    void saveOrUpdate(Customer customer);

    Customer getById(Long cust_id);
}
