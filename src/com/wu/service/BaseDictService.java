package com.wu.service;

import com.wu.domain.BaseDict;

import java.util.List;

public interface BaseDictService {
    List<BaseDict> getListByTypeCode(String dict_type_code);
}
