package com.atguigu.springboot;


import com.atguigu.springboot.dao.UserMapper;
import com.atguigu.springboot.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)//以Spring的方式启动
@SpringBootTest
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testSelectAll(){
        List<User> users = userMapper.selectAll();
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }

}
