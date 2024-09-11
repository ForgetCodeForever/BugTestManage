package com.dlut.bugtestmanage.entity;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (ProjectModule)表实体类
 *
 * @author makejava
 * @since 2024-09-10 19:08:11
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("project_module")
public class ProjectModule  {
    
    @TableId
    private Integer moduleId;


    private String modName;

    private Integer projectId;
    
}
