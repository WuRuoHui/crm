package com.wu.service.impl;

import com.wu.dao.SaleVisitDao;
import com.wu.domain.SaleVisit;
import com.wu.service.SaleVisitService;

public class SaleVisitServiceImpl implements SaleVisitService {

    private SaleVisitDao saleVisitDao;

    @Override
    public void save(SaleVisit saleVisit) {
        saleVisitDao.saveOrUpdate(saleVisit);
    }

    public SaleVisitDao getSaleVisitDao() {
        return saleVisitDao;
    }

    public void setSaleVisitDao(SaleVisitDao saleVisitDao) {
        this.saleVisitDao = saleVisitDao;
    }
}
