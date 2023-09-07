package com.excel.database.service;

import com.excel.database.domain.User;
import com.excel.database.repository.UserRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceimp implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean hasCsvFormat(MultipartFile file) {
        String type = "text/csv";
        if (!type.equals(file.getContentType()))
            return false;
        return true;
    }

    @Override
    public void processAndSaveData(MultipartFile file) {
        try {
            List<User> users = csvtousers(file.getInputStream());
            userRepository.saveAll(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<User> csvtousers(InputStream inputStream) {
        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
            List<User> users=new ArrayList<User>();
            List<CSVRecord> records = csvParser.getRecords();
            for(CSVRecord csvRecord:records)
            {
                User user=new User(Long.parseLong(csvRecord.get(("Id"))),csvRecord.get("weight"),csvRecord.get("height"));
                users.add(user);
            }
         return users;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
