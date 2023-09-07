package com.excel.database.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {
    boolean hasCsvFormat(MultipartFile file);

    void processAndSaveData(MultipartFile file) throws IOException;
}
