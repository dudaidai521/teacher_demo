package com.ujiuye.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ujiuye.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherMapper extends BaseMapper<Teacher> {

}
