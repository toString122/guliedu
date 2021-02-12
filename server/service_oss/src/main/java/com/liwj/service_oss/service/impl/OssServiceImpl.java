package com.liwj.service_oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.liwj.service_oss.service.OssService;
import com.liwj.service_oss.util.ConstantsUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

@Service
public class OssServiceImpl implements OssService {


    @Override
    public String uploadAvatar(MultipartFile file) {
        try {
            String endpoint = ConstantsUtils.END_POINT;
// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
            String accessKeyId = ConstantsUtils.KEY_ID;
            String accessKeySecret = ConstantsUtils.KEY_SECRET;
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            String fileName = UUID.randomUUID().toString()+".jpg";
            String datePath = new DateTime().toString("yyyy/MM/dd");
            fileName = datePath+"/"+fileName;
            InputStream inputStream = file.getInputStream();
            ossClient.putObject(ConstantsUtils.BUCKET_NAME, fileName, inputStream);
            ossClient.shutdown();
            String url = "https://"+ConstantsUtils.BUCKET_NAME+"."+ConstantsUtils.END_POINT+"/"+fileName;
            return url;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
