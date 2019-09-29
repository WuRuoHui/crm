package com.wu.service.impl;

import com.wu.dao.LinkManDao;
import com.wu.domain.LinkMan;
import com.wu.service.LinkManService;

public class LinkManServiceImpl implements LinkManService {

    LinkManDao linkManDao;

    @Override
    public void save(LinkMan linkMan) {
        linkManDao.save(linkMan);
    }

    public void setLinkManDao(LinkManDao linkManDao) {
        this.linkManDao = linkManDao;
    }
}
