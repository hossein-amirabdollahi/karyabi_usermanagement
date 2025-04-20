package com.karyabi.usermanagement.controller;


import com.karyabi.usermanagement.dto.UserDTO;
import com.karyabi.usermanagement.dto.UserSaveDTO;
import com.karyabi.usermanagement.dto.UserUpdateDTO;
import com.karyabi.usermanagement.entity.User;
import com.karyabi.usermanagement.service.UserService;
import jakarta.servlet.ServletRequest;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v2/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String saveUser(@RequestBody UserSaveDTO userSaveDTO) throws IOException {
        return userService.addUser(userSaveDTO);
    }

    @RequestMapping(path = "/getAllUsers", method = RequestMethod.GET)
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(path = "/getById/{id}", method = RequestMethod.GET)
    public UserDTO getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @RequestMapping(path = "/getByUsername/{username}", method = RequestMethod.GET)
    public UserDTO getUserByUsername(@PathVariable String username){
        return userService.getUserByUsername(username);
    }

    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public String updateUser(@RequestBody UserUpdateDTO userUpdateDTO) throws IOException {
        return userService.updateUser(userUpdateDTO);
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id, ServletRequest servletRequest){
        return userService.deleteUser(id);
    }

}
