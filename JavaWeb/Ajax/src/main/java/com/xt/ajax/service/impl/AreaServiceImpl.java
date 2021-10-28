package com.xt.ajax.service.impl;

import com.xt.ajax.dao.AreaDao;
import com.xt.ajax.dao.impl.AreaDaoImpl;
import com.xt.ajax.entity.Area;
import com.xt.ajax.service.AreaService;

import java.util.List;

/**
 * @author xt
 * @Desc
 */
public class AreaServiceImpl implements AreaService {
    private AreaDao areaDao = new AreaDaoImpl();
    @Override
    public List<Area> findListByParentId(Integer parentId) {
        return areaDao.findListByParentId(parentId);
    }
}
