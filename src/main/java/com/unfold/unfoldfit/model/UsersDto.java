package com.unfold.unfoldfit.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersDto {
    private Long userId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String role;
}
