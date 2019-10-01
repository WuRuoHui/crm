package com.wu.service.impl;

import com.wu.dao.SaleVisitDao;
import com.wu.domain.SaleVisit;
import com.wu.service.SaleVisitService;
import com.wu.vo.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class SaleVisitServiceImpl implements SaleVisitService {

    private SaleVisitDao saleVisitDao;

    @Override
    public void save(SaleVisit saleVisit) {
        saleVisitDao.saveOrUpdate(saleVisit);
    }

    @Override
    public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
        Integer totalCount = saleVisitDao.getTotalCount(dc);
        PageBean pageBean = new PageBean(currentPage,totalCount,pageSize);
        List<SaleVisit> saleVisitList = saleVisitDao.getPageList(dc,pageBean.getStart(),pageBean.getPageSize());
        pageBean.setList(saleVisitList);
        return pageBean;
    }

    @Override
    public SaleVisit getById(String visit_id) {
        return saleVisitDao.getById(visit_id);
    }

    public SaleVisitDao getSaleVisitDao() {
        return saleVisitDao;
    }

    public void setSaleVisitDao(SaleVisitDao saleVisitDao) {
        this.saleVisitDao = saleVisitDao;
    }
}
