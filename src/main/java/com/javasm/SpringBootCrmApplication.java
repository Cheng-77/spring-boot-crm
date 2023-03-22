package com.javasm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = {"com.javasm.mapper"})
@EnableAspectJAutoProxy //启用aop
@EnableTransactionManagement  // 开启事务  + @Transactional
public class SpringBootCrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCrmApplication.class, args);
    }

}
