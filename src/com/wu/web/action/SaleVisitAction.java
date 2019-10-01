package com.wu.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wu.domain.SaleVisit;
import com.wu.domain.User;
import com.wu.service.SaleVisitService;
import org.apache.commons.lang3.StringUtils;

public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit> {

    private SaleVisit saleVisit;
    private String visit_id;
    private SaleVisitService saleVisitService;

    public String add() throws Exception {
        if (visit_id==null || StringUtils.isBlank(visit_id)) {
            saleVisit.setVisit_id(null);
        }
        User user = (User) ActionContext.getContext().getSession().get("user");
        saleVisit.setUser(user);
        System.out.println("visit_id："+saleVisit.getVisit_id());
        saleVisitService.save(saleVisit);
        return "toList";
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
}
