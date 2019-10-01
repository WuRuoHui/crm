package com.wu.domain;

import java.util.Date;

public class SaleVisit {
    /*
    visit_id	varchar
    visit_cust_id	bigint			客户id
    visit_user_id	bigint			责人id
    visit_time	date				拜访时间
    visit_interviewee	varchar		被拜访人
    visit_addr	varchar	128			拜访地点
    visit_detail	varchar	256		拜访详情
    visit_nexttime	date			下次拜访时间
    */

    private String visit_id;
    private Date visit_time;
    private String visit_interviewee;
    private String visit_addr;
    private String visit_detail;
    private Date visit_nexttime;

    private User user;
    private Customer customer;

    public String getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(String visit_id) {
        this.visit_id = visit_id;
    }

    public Date getVisit_time() {
        return visit_time;
    }

    public void setVisit_time(Date visit_time) {
        this.visit_time = visit_time;
    }

    public String getVisit_interviewee() {
        return visit_interviewee;
    }

    public void setVisit_interviewee(String visit_interviewee) {
        this.visit_interviewee = visit_interviewee;
    }

    public String getVisit_addr() {
        return visit_addr;
    }

    public void setVisit_addr(String visit_addr) {
        this.visit_addr = visit_addr;
    }

    public String getVisit_detail() {
        return visit_detail;
    }

    public void setVisit_detail(String visit_detail) {
        this.visit_detail = visit_detail;
    }

    public Date getVisit_nexttime() {
        return visit_nexttime;
    }

    public void setVisit_nexttime(Date visit_nexttime) {
        this.visit_nexttime = visit_nexttime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
