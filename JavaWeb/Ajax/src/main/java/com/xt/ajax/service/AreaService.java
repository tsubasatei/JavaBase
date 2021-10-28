package com.xt.ajax.service;

import com.xt.ajax.entity.Area;

import java.util.List;

/**
 * @author xt
 * @Desc
 */
public interface AreaService {
    List<Area> findListByParentId(Integer parentId);
}
