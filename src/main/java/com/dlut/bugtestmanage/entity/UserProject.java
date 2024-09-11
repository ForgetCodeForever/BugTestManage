package com.dlut.bugtestmanage.entity;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (UserProject)表实体类
 *
 * @author makejava
 * @since 2024-09-11 22:05:38
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_project")
public class UserProject  {
    
    @TableId
    private Integer userId;
    
    @TableId
    private Integer projectId;

    
}
