package com.wu.service.impl;

import com.wu.dao.CustomerDao;
import com.wu.domain.Customer;
import com.wu.service.CustomerService;
import com.wu.vo.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;

    @Override
    public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
        Integer totalCount = customerDao.getTotalCount(dc);
        PageBean pageBean = new PageBean(currentPage,totalCount,pageSize);
        List<Customer> customerList = customerDao.getPageList(dc,pageBean.getStart(),pageBean.getPageSize());
        pageBean.setList(customerList);
        return pageBean;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}
