package com.wu.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wu.domain.Customer;
import com.wu.service.CustomerService;
import com.wu.vo.PageBean;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
    private Customer customer;
    private Integer pageSize;
    private Integer currentPage;
    private CustomerService customerService;

    public String list() throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
        if (StringUtils.isNoneBlank(customer.getCust_name())) {
            dc.add(Restrictions.like("cust_name","%"+customer.getCust_name()+"%"));
        }
        System.out.println(pageSize+":"+currentPage);
        PageBean pageBean = customerService.getPageBean(dc,currentPage,pageSize);
        ActionContext.getContext().put("pageBean",pageBean);
        return "toList";
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public Customer getModel() {
        customer = new Customer();
        return customer;
    }
}
