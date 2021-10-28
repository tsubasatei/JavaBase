package com.xt.page.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author xt
 * @Desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page<T> implements Serializable {
    private List<T> data;
    private int totalPage;
    private int totalSize;
    private int currentPage;
    private int pageSize;
}
