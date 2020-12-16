package com.ujiuye.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
public class Teacher {

    @TableId(type = IdType.ID_WORKER_STR)
    private String id;
    private String name;
    private String intro;
    private String career;
    private Integer level;
    private Integer sort;

    //添加时间
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    //修改时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;
}
