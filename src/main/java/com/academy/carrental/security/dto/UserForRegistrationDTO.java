package com.academy.carrental.security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserForRegistrationDTO {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Set<String> roles;

}
