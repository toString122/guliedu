package com.liwj.service_test.client;

import com.liwj.service_base.utils.R;
import org.springframework.stereotype.Component;

/**
 * 服务降级
 */
@Component
public class EduClientImpl implements EduClient {
    @Override
    public R delTea(String id) {
        return R.error().msg("删除出错了");
    }
}
