package com.liwj.service_base.exceptionhandler;


import com.liwj.service_base.utils.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandler {


    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        e.printStackTrace();
        return R.error().msg("执行了全局异常处理。。。");
    }

    /**
     * 自定义异常处理
     * @param e
     * @return
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(GuliException.class)
    @ResponseBody
    public R error(GuliException e){
        e.printStackTrace();
        return R.error().code(e.getCode()).msg(e.getMsg());
    }


}
