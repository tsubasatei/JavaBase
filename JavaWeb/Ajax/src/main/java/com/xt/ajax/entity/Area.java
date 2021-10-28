package com.xt.ajax.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author xt
 * @Desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Area implements Serializable {
    private Integer areaid;
    private String areaname;
    private Integer parentid;
    private Integer arealevel;
    private Integer status;
}
