package com.example.demo.dao;

import com.example.demo.model.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    int updName(Map<String, Object> params);
//   这个方法是自定义的 在xml中写sql
}