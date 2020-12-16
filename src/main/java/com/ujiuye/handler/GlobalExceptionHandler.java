package com.ujiuye.handler;

import com.ujiuye.pojo.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

//统一异常处理类
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return Result.error().message("系统出现异常啦");
    }

    //特定的异常    ArithmeticException
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result error(ArithmeticException e){
        e.printStackTrace();
        return Result.error().message("算术异常！！！");
    }
    //sql异常
    @ExceptionHandler(SQLException.class)
    @ResponseBody
    public Result error(SQLException e){
        e.printStackTrace();
        return Result.error().message("Sql语句出错啦！！！！");
    }
    //类找不到异常


    // 自定义异常
    @ExceptionHandler(ZiException.class)
    @ResponseBody
    public Result error(ZiException e){
        e.printStackTrace();
        return Result.error().code(e.getCode()).message(e.getMsg());
    }


}
