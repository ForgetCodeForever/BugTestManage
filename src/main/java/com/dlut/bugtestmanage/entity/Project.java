package com.dlut.bugtestmanage.entity;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Project)表实体类
 *
 * @author makejava
 * @since 2024-09-10 19:07:15
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("project")
public class Project  {
    
    @TableId
    private Integer projectId;


    private String proName;

    private String proCreatedBy;
    
}
