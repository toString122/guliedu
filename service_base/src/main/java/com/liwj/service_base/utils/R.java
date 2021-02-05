package com.liwj.service_base.utils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0<br>
 * @description: 统一返回结果
 * @author: GLAD.liwj
 * @date: 2021/2/5 11:29
 */
@Data
public class R {
    private Boolean success;
    private Integer code;
    private String msg;
    private Map<String, Object> data = new HashMap<String, Object>();

    private R(){};

    //成功静态方法
    public static R ok(){
        R r = new R();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMsg("成功");
        return r;
    }

    //失败静态方法
    public static R error(){
        R r = new R();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMsg("失败");
        return r;
    }

    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public R msg(String msg){
        this.setMsg(msg);
        return this;
    }

    public R code(Integer code){
        this.setCode(code);
        return this;
    }

    public R data(Map<String,Object> map){
        this.setData(map);
        return this;
    }

    public R data(String key,Object value){
        this.data.put(key, value);
        return this;
    }

}
