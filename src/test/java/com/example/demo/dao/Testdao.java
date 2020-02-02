package com.example.demo.dao;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.config.MybatisPlusConfig;
import com.example.demo.model.User;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Testdao {


    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//        UpdateWrapper<User> updateWrapper = new UpdateWrapper<User>();
        queryWrapper.eq("name_","关羽");
        List<User> userList = userMapper.selectList(queryWrapper);
        System.out.println(userList);
    }
    @Test
    public void testupdate() {
        System.out.println(("----- selectAll method test ------"));

        UpdateWrapper<User> updateWrapper = new UpdateWrapper<User>();
        updateWrapper.eq("name_","关羽");
        updateWrapper.set("age","18");
        User user = new User();
        userMapper.update(user,updateWrapper);

    }

}
