package com.ujiuye.pojo;

import lombok.Data;

//封装讲师的查询条件
@Data
public class TeacherQuery {

    private String name;
    private Integer level;
    private String begin;
    private String end;
}
