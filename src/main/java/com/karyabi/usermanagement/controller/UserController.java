package com.karyabi.usermanagement.controller;


import com.karyabi.usermanagement.dto.UserDTO;
import com.karyabi.usermanagement.dto.UserSaveDTO;
import com.karyabi.usermanagement.dto.UserUpdateDTO;
import com.karyabi.usermanagement.entity.User;
import com.karyabi.usermanagement.service.UserService;
import org.springframework.web.bind.annotation.*;

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
    public String saveUser(@RequestBody UserSaveDTO userSaveDTO){
        return userService.addUser(userSaveDTO);
    }

    @RequestMapping(path = "/getAllUsers", method = RequestMethod.GET)
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

//    @RequestMapping(path = "/update", method = RequestMethod.PUT)
//    public String updateUser(@RequestBody UserUpdateDTO userUpdateDTO){
//        publ
//    }

}
