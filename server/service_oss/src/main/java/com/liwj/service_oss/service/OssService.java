package com.liwj.service_oss.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


public interface OssService  {
    public String uploadAvatar(MultipartFile file);
}
