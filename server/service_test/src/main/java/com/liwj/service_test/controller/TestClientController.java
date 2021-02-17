package com.liwj.service_test.controller;

import com.liwj.service_base.exceptionhandler.GuliException;
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
        R result = eduClient.delTea(id);
        if (result.getCode()==20001){
            new GuliException(20001,"删除失败");
            return result;
        }
        return R.ok();
    }

}
