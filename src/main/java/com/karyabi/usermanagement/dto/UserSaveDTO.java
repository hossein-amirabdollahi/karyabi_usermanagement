package com.karyabi.usermanagement.dto;

import com.karyabi.usermanagement.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSaveDTO {

    private String fullName;

    private String username;

    private String password;

    private String email;

    private String phoneNumber;

    private String address;

    private Role role;
}
