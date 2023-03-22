package com.javasm.controller;

import com.javasm.common.http.AxiosResult;
import com.javasm.common.utils.UploadUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Part;

/**
 * @Author：TangXingyu
 * @Version：1.0
 * @Date：2023/3/22-9:42
 * @Since：jdk1.8
 * @Description：
 */
@RestController
public class UploadController {

    @PostMapping("upload")
    public AxiosResult<String> upload(@RequestPart Part part){
        //进行文件上传  UploadUtil
        String upload = UploadUtil.upload(part);
        return AxiosResult.success(upload);
    }
}
