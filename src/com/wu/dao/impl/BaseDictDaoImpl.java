package com.wu.dao.impl;

import com.wu.dao.BaseDictDao;
import com.wu.domain.BaseDict;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao {
    @Override
    public List<BaseDict> getListByTypeCode(String dict_type_code) {
        DetachedCriteria dc = DetachedCriteria.forClass(BaseDict.class);
        dc.add(Restrictions.eq("dict_type_code",dict_type_code));
        return  (List<BaseDict>) getHibernateTemplate().findByCriteria(dc);
    }
}
