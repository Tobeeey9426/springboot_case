package com.atguigu.springboot;

import com.atguigu.springboot.pojo.User;
import com.atguigu.springboot.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void findAll()  {

        try {
            List<User> users = userService.findAll();
            for (User user : users) {
                System.out.println("user = " + user);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
