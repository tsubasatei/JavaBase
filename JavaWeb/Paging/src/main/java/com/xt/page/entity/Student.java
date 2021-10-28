package com.xt.page.entity;

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
public class Student implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private String filename;
    private String filetype;
}
