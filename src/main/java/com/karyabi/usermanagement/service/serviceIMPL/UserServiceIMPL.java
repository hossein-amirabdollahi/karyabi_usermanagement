package com.karyabi.usermanagement.service.serviceIMPL;

import com.karyabi.usermanagement.dto.UserDTO;
import com.karyabi.usermanagement.dto.UserSaveDTO;
import com.karyabi.usermanagement.dto.UserUpdateDTO;
import com.karyabi.usermanagement.entity.User;
import com.karyabi.usermanagement.repository.UserRepository;
import com.karyabi.usermanagement.service.UserService;
import com.karyabi.usermanagement.util.HashUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceIMPL implements UserService {

    private final HashUtil hashUtil;
    private final UserRepository userRepository;

    public UserServiceIMPL(UserRepository userRepository, HashUtil hashUtil) {
        this.userRepository = userRepository;
        this.hashUtil = hashUtil;
    }

    private UserDTO mapToDTO(User user){
        return UserDTO.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .username(user.getUsername())
                .email(user.getEmail())
                .address(user.getAddress())
                .role(user.getRole())
                .phoneNumber(user.getPhoneNumber())
                .build();
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

        return "User with username:{ " + user.getUsername() + " } registered successfully";
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        List<UserDTO> allUserDTO = new ArrayList<>();

        for (User user : allUsers) {

            UserDTO userDTO = this.mapToDTO(user);

            allUserDTO.add(userDTO);
        }
        return allUserDTO;
    }

    @Override
    public UserDTO getUserById(Long id) {
        if (userRepository.existsById(id)) {
            User user = userRepository.getById(id);
            return this.mapToDTO(user);
        } else {
            throw new NoSuchElementException("User not found with ID: " + id);
        }
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        if (!userRepository.existsByUsername(username))
            throw new NoSuchElementException("User not found with ID: " + username);
        User user = userRepository.getByUsername(username);
        return this.mapToDTO(user);
    }

    @Override
    public String updateUser(UserUpdateDTO userUpdateDTO) {
        if (!userRepository.existsById(userUpdateDTO.getId())){
            return "User not found with ID: " + userUpdateDTO.getId();
        }else {
            User user = userRepository.getById(userUpdateDTO.getId());
            user.setFullName(userUpdateDTO.getFullName());
            user.setUsername(userUpdateDTO.getUsername());
            user.setEmail(userUpdateDTO.getEmail());
            user.setPhoneNumber(userUpdateDTO.getPhoneNumber());
            user.setAddress(userUpdateDTO.getAddress());
            user.setRole(userUpdateDTO.getRole());
            userRepository.save(user);
            return userUpdateDTO.getUsername();
        }
    }

    @Override
    public String deleteUser(Long id) {
        if(!userRepository.existsById(id))
            return "User not found with ID: " + id;
        userRepository.deleteById(id);
        return "User with ID:{ "+ id+ " } delete successfully.";
    }
}
