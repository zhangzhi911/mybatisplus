package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.dao.UserMapper;
import com.example.demo.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Resource
    private UserMapper userMapper;

    @RequestMapping("/list")
    public List<User> testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        System.out.println(userList);
        return userList;
    }


    @RequestMapping("/add")
    public String add() {
        User user = new User();
        user.setId(14L);
        user.setName("关羽");
        user.setAge(12);
        userMapper.insert(user);
        return "成功了";
    }

    @RequestMapping("/upd")
    public String upd() {
        User user = new User();
        user.setId(13L);
        user.setName("zyg");
        user.setAge(13);
        userMapper.updateById(user);
        return "成功了";

    }
    @RequestMapping("/upd2")
    public String upd2() {
        User user=new User();
        user.setId(13L);
        user.setName("张洋小朋友");
        user.setAge(13);
//        user.setVersion(1);
        if(  userMapper.updateById(user)>0){
            System.err.println("更新成功");
        }
        else {
            System.err.println("被其他人更新");
        }
        return "成功了";

    }


    @RequestMapping("/updWrap")
    public String updWrap() {
        User user = new User();
        user.setAddress("广州");
        user.setAge(23);
        userMapper.update(user, new UpdateWrapper<User>().eq("name_", "a").or().eq("name_", "b"));
        return "成功了";

    }

    //    据 MAP 传值更新
    @RequestMapping("/updName")
    public String updName() {
        Map<String, Object> params = new HashMap<String, Object>();

        params.put("id", 14);
        params.put("name", "趙雲");

        int i = userMapper.updName(params);
        System.err.println(i);
        return "成功了";

    }

    @RequestMapping("/getPage")
    public IPage<User> getPage() {


        Page<User> page = new Page<User>(1, 2);
        IPage<User> userIPage = userMapper.selectPage(page, null);

        System.err.println(userIPage.getRecords());
//        这个需要配合MybatisPlusConfig 的分页配置，才可以生效。
        return  userIPage;
    }


    @RequestMapping("/getPageMap")
    public  void getPageMap(){
        Page page = new Page<Integer>(1, 5);

        Wrapper wrapper=new QueryWrapper();
        ((QueryWrapper) wrapper).ge("id_",2);

        IPage<Map<String,Object>> userIPage = userMapper.selectMapsPage(page,wrapper);
        System.err.println(userIPage.getRecords().toString());
        System.out.println(userIPage.getTotal());
//        这里我们查询Id_ 大于 2的用户分页列表。
    }

    @RequestMapping("/delById")
    public  void delById(){
        userMapper.deleteById(1L);
    }
}