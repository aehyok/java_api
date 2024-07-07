package com.sun.xxm.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="file", description = "文件")
@RestController
@RequestMapping("/api/file")
public class FileController {

    @Operation(summary = "上传文件")
    @PostMapping()
    public String PostFile(String fileName) {
        return "success";
    }
}
