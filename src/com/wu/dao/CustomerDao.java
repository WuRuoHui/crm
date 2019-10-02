package com.wu.dao;

import com.wu.domain.Customer;

import java.util.List;

public interface CustomerDao extends BaseDao<Customer> {

    List<Object> getIndustryCount();
}
