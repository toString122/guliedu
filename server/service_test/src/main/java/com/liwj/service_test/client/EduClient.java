package com.liwj.service_test.client;

import com.liwj.service_base.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * FeignClients 调用edu服务中的方法
 */
@FeignClient(name = "service-edu",fallback = EduClientImpl.class)
@Component
public interface EduClient {
    @DeleteMapping("/service_edu/edu-teacher/delTea/{id}")
    R delTea(@PathVariable("id") String id);
}
