package com.karyabi.usermanagement.service;

import com.karyabi.usermanagement.dto.UserDTO;
import com.karyabi.usermanagement.dto.UserSaveDTO;
import com.karyabi.usermanagement.dto.UserUpdateDTO;

import java.util.List;

public interface UserService {
    String addUser(UserSaveDTO userSaveDTO);

    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id);

    UserDTO getUserByUsername(String username);

    String updateUser(UserUpdateDTO userUpdateDTO);

    String deleteUser(Long id);
}
