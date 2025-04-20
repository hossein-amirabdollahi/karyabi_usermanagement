package com.karyabi.usermanagement.service;

import com.karyabi.usermanagement.dto.UserDTO;

import java.io.IOException;

public interface UserFileService {
    public void writerUserToFile(UserDTO userDTO) throws IOException;
    public void deleteUserFile(String username);
}
