package com.lanlinker.cloud.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传服务
 * Created by MetalSteel on 2017/8/29.
 */
@RestController
public class FileUploadController {
    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam(value = "file",required = true)@RequestBody MultipartFile file) throws IOException {
        String  newFilePath = "E:/WorkCase/Temp/"+file.getOriginalFilename();
        file.transferTo(new File(newFilePath));
        return newFilePath;
    }
}
