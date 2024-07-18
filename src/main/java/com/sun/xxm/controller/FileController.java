package com.sun.xxm.controller;

import com.sun.xxm.service.FileMapper;
import com.sun.xxm.model.File;
import com.sun.xxm.utils.ApiException;
import com.sun.xxm.utils.FileUtil;
import com.sun.xxm.utils.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Tag(name="file", description = "文件")
@RestController
@RequestMapping("/apis/file")
public class FileController {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Autowired
    private FileMapper fileMapper;

    @Operation(summary = "上传文件")
    @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public File PostFile(@RequestPart("file")MultipartFile file) throws IOException {

        if(file.isEmpty()) {
            throw new ApiException(ResultCodeEnum.FAILED, "请选择上传文件");
        }

        File fileInfo = new File();
        fileInfo.setSize(file.getSize());
//        fileInfo.setExtension(file.get);

        String originalFileName = file.getOriginalFilename();

        fileInfo.setName(originalFileName);

        var extension = FileUtil.getFileExtension(file.getOriginalFilename());
        fileInfo.setExtension(extension);
//        fileInfo.setType(FileTypeEnum.Image);
        fileInfo.setContent_type(file.getContentType());

        fileMapper.insert(fileInfo);

        FileUtil.saveFile(file, uploadDir, fileInfo.getId() + "." + fileInfo.getExtension());

        return fileInfo;
    }
}
