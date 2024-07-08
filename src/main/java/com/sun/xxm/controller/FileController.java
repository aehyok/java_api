package com.sun.xxm.controller;

import com.sun.xxm.utils.ApiException;
import com.sun.xxm.utils.FileUtil;
import com.sun.xxm.utils.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Tag(name="file", description = "文件")
@RestController
@RequestMapping("/api/file")
public class FileController {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Operation(summary = "上传文件")
    @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String PostFile(@RequestPart("file")MultipartFile file) throws IOException {

        if(file.isEmpty()) {
            throw new ApiException(ResultCodeEnum.FAILED, "请选择上传文件");
        }

        String originalFileName = file.getOriginalFilename();

        FileUtil.saveFile(file, uploadDir);

        return "success";
    }
}
