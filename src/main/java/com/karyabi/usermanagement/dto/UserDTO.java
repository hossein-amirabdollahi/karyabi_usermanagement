package com.karyabi.usermanagement.dto;

import com.karyabi.usermanagement.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    private String fullName;

    private String username;

    private String email;

    private String phoneNumber;

    private String address;

    private Role role;
}
