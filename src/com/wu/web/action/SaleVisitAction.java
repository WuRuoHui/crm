package com.wu.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wu.domain.SaleVisit;
import com.wu.domain.User;
import com.wu.service.SaleVisitService;
import com.wu.vo.PageBean;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit> {

    private SaleVisit saleVisit;
    private String visit_id;
    private SaleVisitService saleVisitService;

    private Integer pageSize;
    private Integer currentPage;

    public String list() throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(SaleVisit.class);
        if (saleVisit.getCustomer() != null && saleVisit.getCustomer().getCust_id() != null) {
            dc.add(Restrictions.eq("customer.cust_id", saleVisit.getCustomer().getCust_id()));
        }
        PageBean pageBean = saleVisitService.getPageBean(dc, currentPage, pageSize);
        ActionContext.getContext().put("pageBean", pageBean);
        String parameter = ServletActionContext.getRequest().getParameter("select");
        return "list";
    }

    public String add() throws Exception {
        if (saleVisit.getVisit_id() == null || StringUtils.isBlank(saleVisit.getVisit_id())) {
            saleVisit.setVisit_id(null);
        }
        User user = (User) ActionContext.getContext().getSession().get("user");
        saleVisit.setUser(user);
        System.out.println("visit_id：" + saleVisit.getVisit_id());
        saleVisitService.save(saleVisit);
        return "toList";
    }

    public String edit() throws Exception {
        SaleVisit sv = saleVisitService.getById(saleVisit.getVisit_id());
        ServletActionContext.getContext().put("saleVisit",sv);
        return "toEdit";
    }

    @Override
    public SaleVisit getModel() {
        saleVisit = new SaleVisit();
        return saleVisit;
    }

    public SaleVisitService getSaleVisitService() {
        return saleVisitService;
    }

    public void setSaleVisitService(SaleVisitService saleVisitService) {
        this.saleVisitService = saleVisitService;
    }

    public String getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(String visit_id) {
        this.visit_id = visit_id;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
}
