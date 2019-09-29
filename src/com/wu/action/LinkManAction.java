package com.wu.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wu.domain.LinkMan;
import com.wu.service.LinkManService;
import com.wu.vo.PageBean;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

    private LinkMan linkMan;
    private LinkManService linkManService;

    private Integer currentPage;
    private Integer pageSize;

    public String add() throws Exception {
        System.out.println(linkMan);
        linkManService.save(linkMan);
        return "toList";
    }

    public String edit() throws Exception {
        LinkMan lm = linkManService.getById(linkMan.getLkm_id());
        ActionContext.getContext().put("linkMan",lm);
        return "toEdit";
    }

    public String list() throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
        if (StringUtils.isNoneBlank(linkMan.getLkm_name())){
            dc.add(Restrictions.like("lkm_name","%"+linkMan.getLkm_name()+"%"));
        }
        if (linkMan.getCustomer()!=null&&linkMan.getCustomer().getCust_id()!=null){
            dc.add(Restrictions.eq("customer.cust_id",linkMan.getCustomer().getCust_id()));
            System.out.println(linkMan.getCustomer().getCust_id());
        }
        PageBean pageBean = linkManService.getPageBean(dc,currentPage,pageSize);
        ActionContext.getContext().put("pageBean",pageBean);
        System.out.println(pageBean.getList());
        return "list";
    }

    @Override
    public LinkMan getModel() {
        linkMan = new LinkMan();
        return linkMan;
    }

    public void setLinkManService(LinkManService linkManService) {
        this.linkManService = linkManService;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
