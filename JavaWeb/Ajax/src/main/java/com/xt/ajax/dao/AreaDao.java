package com.xt.ajax.dao;

import com.xt.ajax.entity.Area;

import java.util.List;

/**
 * @author xt
 * @Desc
 */
public interface AreaDao {
    List<Area> findListByParentId(Integer parentId);
}
