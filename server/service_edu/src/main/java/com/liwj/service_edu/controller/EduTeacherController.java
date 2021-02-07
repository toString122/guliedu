package com.liwj.service_edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liwj.service_base.exceptionhandler.GuliException;
import com.liwj.service_edu.entity.EduTeacher;
import com.liwj.service_edu.entity.vo.TeacherQuery;
import com.liwj.service_edu.service.EduTeacherService;
import com.liwj.service_base.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
@CrossOrigin
@RestController
@RequestMapping("/service_edu/edu-teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;

    @GetMapping("findAllTea")
    public R findAllTea(){
//        try {
//            final int i = 10 / 0;
//        } catch (Exception e) {
//            throw new GuliException(20001,"执行了自定义异常处理");
//        }
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

    @GetMapping("pageTea/{current}/{size}")
    public R pageListTea(@PathVariable int current,
                         @PathVariable int size){
        Page<EduTeacher> page = new Page<>(current,size);
        final IPage<EduTeacher> page1 = teacherService.page(page);
        final long total = page1.getTotal();
        final List<EduTeacher> records = page1.getRecords();
        return R.ok().code(20000).data("total",total).
                data("list",records);
    }

    @PostMapping("pageTeaCondition/{current}/{size}")
    public R pageTeaCondition(@PathVariable int current,
                              @PathVariable int size,
                              @RequestBody(required = false) TeacherQuery teacherQuery){
        Page<EduTeacher> page = new Page<>(current,size);

        QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper<>();

        final String name = teacherQuery.getName();
        final Integer level = teacherQuery.getLevel();
        final String begin = teacherQuery.getBegin();
        final String end = teacherQuery.getEnd();
        if (!StringUtils.isEmpty(name)) {
            queryWrapper.like("name",name);
        }
        if (!StringUtils.isEmpty(level)){
            queryWrapper.eq("level",level);
        }
        if (!StringUtils.isEmpty(begin)){
            queryWrapper.ge("gmt_create",begin);
        }
        if (!StringUtils.isEmpty(end)){
            queryWrapper.le("gmt_modified",end);
        }

        queryWrapper.orderByDesc("gmt_create");


        final IPage<EduTeacher> teaPage = teacherService.page(page,queryWrapper);
        final long total = teaPage.getTotal();
        final List<EduTeacher> records = teaPage.getRecords();
        return R.ok().code(20000).data("total",total).
                data("list",records);
    }

    @PostMapping("addTea")
    public R addTea(@RequestBody EduTeacher teacher){
        final boolean save = teacherService.save(teacher);
        if (save){
            return R.ok();
        }else {
            return R.error();
        }
    }

    @GetMapping("getTea/{id}")
    public R getTea(@PathVariable String id){
        final EduTeacher teacher = teacherService.getById(id);
        return R.ok().data("teacher",teacher);
    }

    @PostMapping("updateTea")
    public R updateTea(@RequestBody EduTeacher teacher){
        final boolean update = teacherService.updateById(teacher);
        if (update){
            return R.ok();
        }else {
            return R.error();
        }
    }



}

