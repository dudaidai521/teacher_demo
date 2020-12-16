package com.ujiuye.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ujiuye.mapper.TeacherMapper;
import com.ujiuye.pojo.Teacher;
import com.ujiuye.pojo.TeacherQuery;
import com.ujiuye.service.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
    @Override
    public void pageListQuery(Page<Teacher> pageParam, TeacherQuery query) {
        //条件构造器
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        //判断
        if(wrapper == null){
            baseMapper.selectPage(pageParam,null);
            return;
        }
        //获取query的值进行判断
        String name = query.getName();
        Integer level =  query.getLevel();
        String beign = query.getBegin();
        String end = query.getEnd();
        if(!StringUtils.isEmpty(name)){
            wrapper.like("name",name);
        }
        if(!StringUtils.isEmpty(level)){
            wrapper.eq("level",level);
        }
        if(!StringUtils.isEmpty(beign)){
            wrapper.ge("create_time",beign);
        }
        if(!StringUtils.isEmpty(end)){
            wrapper.le("create_time",end);
        }
        baseMapper.selectPage(pageParam,wrapper);
    }
}
