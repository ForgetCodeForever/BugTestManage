package com.dlut.bugtestmanage.controller;

import com.dlut.bugtestmanage.ResponseResult;
import com.dlut.bugtestmanage.entity.User;
import com.dlut.bugtestmanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseResult register(@RequestBody User user) {
        return userService.register(user);
    }
}

