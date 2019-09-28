package com.wu.service.impl;

import com.wu.dao.BaseDictDao;
import com.wu.domain.BaseDict;
import com.wu.service.BaseDictService;

import java.util.List;

public class BaseDictServiceImpl implements BaseDictService {
    private BaseDictDao baseDictDao;
    @Override
    public List<BaseDict> getListByTypeCode(String dict_type_code) {
        return baseDictDao.getListByTypeCode(dict_type_code);
    }

    public void setBaseDictDao(BaseDictDao baseDictDao) {
        this.baseDictDao = baseDictDao;
    }
}
