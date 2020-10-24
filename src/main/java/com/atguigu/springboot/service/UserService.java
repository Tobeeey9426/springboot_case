package com.atguigu.springboot.service;

import com.atguigu.springboot.pojo.User;

import java.io.FileNotFoundException;
import java.util.List;

public interface UserService {

    public List<User> findAll() throws FileNotFoundException;
}
