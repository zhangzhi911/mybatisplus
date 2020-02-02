package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;


@TableName(value = "User_")
@Data
public class User {
    @TableId(value = "id_")
    private Long id;
    @TableField(value = "name_")
    private String name;
    private Integer age;
    private String address;
    @TableLogic
    @TableField(value = "isDelete")
    private Integer isDelete;
//    @Version
//    private Integer version;
//    version这是字段没有的稍后讲解
}