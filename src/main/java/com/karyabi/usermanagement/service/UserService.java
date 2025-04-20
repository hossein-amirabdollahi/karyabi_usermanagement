package com.karyabi.usermanagement.service;

import com.karyabi.usermanagement.dto.UserDTO;
import com.karyabi.usermanagement.dto.UserSaveDTO;
import com.karyabi.usermanagement.dto.UserUpdateDTO;

import java.io.IOException;
import java.util.List;

public interface UserService {
    String addUser(UserSaveDTO userSaveDTO) throws IOException;

    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id);

    UserDTO getUserByUsername(String username);

    String updateUser(UserUpdateDTO userUpdateDTO) throws IOException;

    String deleteUser(Long id);
}
