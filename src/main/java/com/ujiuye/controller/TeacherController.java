package com.ujiuye.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ujiuye.handler.ZiException;
import com.ujiuye.pojo.Teacher;
import com.ujiuye.pojo.TeacherQuery;
import com.ujiuye.pojo.result.Result;
import com.ujiuye.service.TeacherService;
import jdk.internal.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    //添加讲师
    @PostMapping
    public Result saveTeacher(@RequestBody Teacher teacher){
        System.out.println("添加讲师");
       boolean b =  teacherService.save(teacher);
       if(b){
           return Result.ok();
       }else{
           return  Result.error();
       }
    }
    //查询所有讲师
    @GetMapping
    public Result selectAll(){

        try {
            int i = 1 / 0;
        }catch (Exception e){
            throw new ZiException(20002,"除零异常啦！！！！！");
        }

        List<Teacher> list = teacherService.list(null);
        return  Result.ok().data("items",list);

    }

    // 根据id 进行修改

    @PutMapping("{id}")
    public Result updateById(@PathVariable  String id,@RequestBody Teacher teacher){
        teacher.setId(id);
        boolean b = teacherService.updateById(teacher);
        if(b){
            return Result.ok();
        }else{
            return  Result.error();
        }
    }

    //根据id删除

    @DeleteMapping("{id}")
    public  Result deleteById(@PathVariable String id){
        boolean b = teacherService.removeById(id);
        if(b){
            return Result.ok();
        }else{
            return  Result.error();
        }
    }

    //分页查询
    @GetMapping("{page}/{limit}")
    public Result pageList(@PathVariable Long page,@PathVariable Long limit){
        Page<Teacher> pageParam = new Page<>(page,limit);
        teacherService.page(pageParam,null);
        //查询某一页的数据
        List<Teacher> list = pageParam.getRecords();
        //查询总记录数
        long total = pageParam.getTotal();
        return Result.ok().data("total",total).data("rows",list);
    }
    // 分页条件查询
    @PostMapping("{page}/{limit}")
    public Result pageListQuery(@PathVariable Long page, @PathVariable Long limit,
                                @RequestBody TeacherQuery query){
        Page<Teacher> pageParam = new Page<>(page,limit);

        teacherService.pageListQuery(pageParam,query);
        //查询某一页的数据
        List<Teacher> list = pageParam.getRecords();
        //查询总记录数
        long total = pageParam.getTotal();
        return Result.ok().data("total",total).data("rows",list);
    }



}
