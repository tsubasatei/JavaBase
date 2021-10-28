package com.xt.ajax.dao.impl;

import com.xt.ajax.dao.AreaDao;
import com.xt.ajax.dao.BaseDao;
import com.xt.ajax.entity.Area;

import java.util.List;

/**
 * @author xt
 * @Desc
 */
public class AreaDaoImpl extends BaseDao implements AreaDao {
    @Override
    public List<Area> findListByParentId(Integer parentId) {
        String sql = "select * from area where parentid = ?";
        List<Area> list = this.baseQuery(Area.class, sql, parentId);
        return list;
    }
}
