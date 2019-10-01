package com.wu.service;

import com.wu.domain.SaleVisit;
import com.wu.vo.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public interface SaleVisitService {
    void save(SaleVisit saleVisit);

    PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

    SaleVisit getById(String visit_id);
}
