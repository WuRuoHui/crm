package com.wu.service.impl;

import com.wu.dao.LinkManDao;
import com.wu.domain.LinkMan;
import com.wu.service.LinkManService;
import com.wu.vo.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class LinkManServiceImpl implements LinkManService {

    LinkManDao linkManDao;

    @Override
    public void save(LinkMan linkMan) {
        linkManDao.saveOrUpdate(linkMan);
    }

    @Override
    public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
        Integer totalCount = linkManDao.getTotalCount(dc);
        PageBean pageBean = new PageBean(currentPage,totalCount,pageSize);
        List<LinkMan> pageList = linkManDao.getPageList(dc, pageBean.getStart(), pageBean.getPageSize());
        pageBean.setList(pageList);
        return pageBean;
    }

    @Override
    public LinkMan getById(Long lkm_id) {
        return linkManDao.getById(lkm_id);
    }

    public void setLinkManDao(LinkManDao linkManDao) {
        this.linkManDao = linkManDao;
    }
}
