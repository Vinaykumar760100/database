package com.excel.database.controller;

import com.excel.database.response.ResposeMessage;
import com.excel.database.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("upload")
    public ResponseEntity<ResposeMessage> uploadFile(@RequestParam("file")MultipartFile file) throws IOException {
        if(userService.hasCsvFormat(file)){
           userService.processAndSaveData(file);
            return ResponseEntity.status(HttpStatus.OK).body(new ResposeMessage("Csv file upload successfully:"+file.getOriginalFilename()));
        }
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResposeMessage("please upload csv file"));
    }

    {

    }
}
