package com.karyabi.usermanagement.service.serviceIMPL;


import com.karyabi.usermanagement.dto.UserDTO;
import com.karyabi.usermanagement.service.UserFileService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class UserFileServiceIMPL implements UserFileService {
    private static final String basePath = "D:\\work space\\Back-End\\Java\\beginner\\project\\usermanagement\\users";

    @Override
    public void writerUserToFile(UserDTO userDTO) throws IOException {
        File dir = new File(basePath);
        if(!dir.exists())
            dir.mkdir();

        File file = new File(dir,userDTO.getUsername() + ".txt");

        try(FileWriter writer = new FileWriter(file, false)){
            writer.write("ID: " + userDTO.getId() + "\n");
            writer.write("Full Name: " + userDTO.getFullName() + "\n");
            writer.write("Username: " + userDTO.getUsername() + "\n");
            writer.write("Email: " + userDTO.getEmail() + "\n");
            writer.write("Phone: " + userDTO.getPhoneNumber() + "\n");
            writer.write("Address: " + userDTO.getAddress() + "\n");
            writer.write("Role: " + userDTO.getRole() + "\n");
        }
    }

    @Override
    public void deleteUserFile(String username){
        File file = new File(basePath, username + ".txt");
        if(file.exists())
            file.delete();
    }
}
