package com.liwj.service_oss.controller;

import com.liwj.service_base.utils.R;
import com.liwj.service_oss.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/eduoss/fileoss")
public class OssController {

    @Autowired
    private OssService ossService;


    @PostMapping("uploadFile")
    public R uploadOssFile(MultipartFile file){
        final String url = ossService.uploadAvatar(file);



        return R.ok();
    }
}
