package com.sun.xxm.utils;

import com.sun.xxm.model.File;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {

    public static void saveFile(MultipartFile file, String uploadDir, String fileName) throws IOException {
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // 保存文件到指定目录
        byte[] bytes = file.getBytes();
        Path filePath = uploadPath.resolve(fileName);
        Files.write(filePath, bytes);
    }

    public static String getFileExtension(String fileName) {
        if (fileName == null || fileName.lastIndexOf(".") == -1) {
            return null;
        }
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}

