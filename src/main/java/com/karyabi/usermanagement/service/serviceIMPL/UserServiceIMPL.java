package com.karyabi.usermanagement.service.serviceIMPL;

import com.karyabi.usermanagement.dto.UserDTO;
import com.karyabi.usermanagement.dto.UserSaveDTO;
import com.karyabi.usermanagement.entity.User;
import com.karyabi.usermanagement.model.enums.Role;
import com.karyabi.usermanagement.repository.UserRepository;
import com.karyabi.usermanagement.service.UserService;
import com.karyabi.usermanagement.util.HashUtil;
import io.micrometer.common.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceIMPL implements UserService {

    private final HashUtil hashUtil;
    private final UserRepository userRepository;

    public UserServiceIMPL(UserRepository userRepository, HashUtil hashUtil){
        this.userRepository = userRepository;
        this.hashUtil = hashUtil;
    }

    @Override
    public String addUser(UserSaveDTO userSaveDTO) {

        User user = User.builder()
                .fullName(userSaveDTO.getFullName())
                .username(userSaveDTO.getUsername())
                .password(hashUtil.hashWithMD5((userSaveDTO.getPassword())))
                .email(userSaveDTO.getEmail())
                .phoneNumber(userSaveDTO.getPhoneNumber())
                .address(userSaveDTO.getAddress())
                .role(userSaveDTO.getRole())
                .build();

        userRepository.save(user);

        return "User with username:{ "+ user.getUsername()+" } registered successfully";
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        List<UserDTO> allUserDTO = new ArrayList<>();

        for (User user : allUsers){

            UserDTO userDTO = UserDTO.builder()
                    .id(user.getId())
                    .fullName(user.getFullName())
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .address(user.getAddress())
                    .role(user.getRole())
                    .phoneNumber(user.getPhoneNumber())
                    .build();

            allUserDTO.add(userDTO);
        }
        return allUserDTO;
    }
}
