package com.atguigu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

//设置扫描dao层的包,否则,无法创建dao的对象,一定导入tk.mybatis通用Mapper包
@MapperScan(basePackages = "com.atguigu.springboot.dao")
@SpringBootApplication
@EnableTransactionManagement//开启声明式事务
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
