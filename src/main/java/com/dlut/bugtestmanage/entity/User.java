package com.dlut.bugtestmanage.entity;


import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (User)表实体类
 *
 * @author makejava
 * @since 2024-09-10 19:12:25
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User  {
    
    @TableId
    private Integer userId;


    private String username;

    private String password;

    private String email;

    private String phoneNumber;

    private Integer roleId;

    private Integer projectId;

    private String status;

    @TableField(exist = false)
    private String role;
    
}
