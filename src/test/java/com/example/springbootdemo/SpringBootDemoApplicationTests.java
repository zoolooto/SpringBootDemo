package com.example.springbootdemo;

import com.example.springbootdemo.Dao.UserMapper;
import com.example.springbootdemo.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@SpringBootTest
class SpringBootDemoApplicationTests {

    @Test
    void contextLoads() {

    }
}
