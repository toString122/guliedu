package com.liwj.service_edu.controller;


import com.liwj.service_edu.entity.EduTeacher;
import com.liwj.service_edu.service.EduTeacherService;
import com.lwj.service_base.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author liwj
 * @since 2021-02-05
 */
@RestController
@RequestMapping("/service_edu/edu-teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;

    @GetMapping("findAllTea")
    public R findAllTea(){
        List<EduTeacher> list = teacherService.list(null);
        return R.ok().code(20000).msg("成功").data("item",list);
    }

    @DeleteMapping("delTea/{id}")
    public R delTea(@PathVariable("id") String id){
        boolean b = teacherService.removeById(id);
        if (b){
            return R.ok();
        }else {
            return R.error();
        }
    }

}

