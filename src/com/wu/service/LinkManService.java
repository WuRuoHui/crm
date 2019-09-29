package com.wu.service;

import com.wu.domain.LinkMan;
import com.wu.vo.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public interface LinkManService {
    void save(LinkMan linkMan);

    PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
}
