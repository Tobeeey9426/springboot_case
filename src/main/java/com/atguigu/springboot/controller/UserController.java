package com.atguigu.springboot.controller;


import com.atguigu.springboot.pojo.User;
import com.atguigu.springboot.service.UserService;
import com.atguigu.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/user/findAll")
    public Result findAll(){

        try {
            List<User> usersList = userService.findAll();

            return Result.ok(true,"成功",usersList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return Result.error(false,"失败");
        }

    }
}
