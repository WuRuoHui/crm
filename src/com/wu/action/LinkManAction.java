package com.wu.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wu.domain.LinkMan;
import com.wu.service.LinkManService;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

    private LinkMan linkMan;
    private LinkManService linkManService;

    public String add() throws Exception {
        linkManService.save(linkMan);
        return "toList";
    }

    @Override
    public LinkMan getModel() {
        linkMan = new LinkMan();
        return linkMan;
    }

    public void setLinkManService(LinkManService linkManService) {
        this.linkManService = linkManService;
    }
}
