package com.academy.carrental.controller;

import com.academy.carrental.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value="exists/by-username/{username}")
    public ResponseEntity<Map<String, Boolean>> doesUsernameExists(@PathVariable String username)
    {
        boolean existsStatus = userService.existsByUsername(username);
        return new ResponseEntity<>(Collections.singletonMap("status", existsStatus), HttpStatus.OK);


    }

}
