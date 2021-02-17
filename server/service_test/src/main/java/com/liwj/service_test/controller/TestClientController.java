package com.liwj.service_test.controller;

import com.liwj.service_base.utils.R;
import com.liwj.service_test.client.EduClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/service_test/client")
public class TestClientController {

    @Autowired
    private EduClient eduClient;

    @DeleteMapping("deleteTest/{id}")
    public R t1(@PathVariable("id")String id){
        eduClient.delTea(id);
        return R.ok();
    }

    @DeleteMapping("a")
    public R t2(@PathVariable("id")String id){

        return R.ok().data("test","调用成功");
    }
}
