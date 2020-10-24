package com.atguigu.springboot.service.impl;

import com.atguigu.springboot.dao.UserMapper;
import com.atguigu.springboot.pojo.User;
import com.atguigu.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisTemplate redisTemplate;

    //@Transactional(readOnly = true)//只读
    //propagation传播行为 :7种
    //isolation 事务隔离级别:4种
    //问题 : 数据丢失 脏读 不可重复读 幻读
    //1 读未提交READ_UNCOMMITTED 可以解决数据丢失 不能解决脏读
    //2 读已提交READ_COMMITTED   oracle默认隔离级别
    //4 可重复读REPEATABLE_READ   MySQL默认隔离级别
    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.REPEATABLE_READ,
            rollbackFor = Exception.class,
            noRollbackFor = FileNotFoundException.class
    )
    @Override
    public List<User> findAll() {
        //int i = 1/0  //运行时异常,SpringAOP声明式事务,默认对运行时异常进行回滚
//        FileInputStream asd = new FileInputStream("asd");//编译时异常,默认不会滚

        List<User> users = (List<User>) redisTemplate.boundValueOps("userkey").get();
        if (users == null){//缓存中没有
            users = userMapper.selectAll();
            System.out.println("数据库users = " + users);
            redisTemplate.boundValueOps("userkey").set(users);

        }else {//缓存中有
            System.out.println("缓存中users" + users);
        }

        return users;
    }
}
