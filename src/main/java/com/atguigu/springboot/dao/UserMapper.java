package com.atguigu.springboot.dao;

import com.atguigu.springboot.pojo.User;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

//通用Mapper,简化MyBatis开发

@Repository
public interface UserMapper extends Mapper<User> {

}
