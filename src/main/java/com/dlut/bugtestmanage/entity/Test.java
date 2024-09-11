package com.dlut.bugtestmanage.entity;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Test)表实体类
 *
 * @author makejava
 * @since 2024-09-10 19:10:36
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("test")
public class Test  {
    
    @TableId
    private Integer testId;


    private Integer moduleId;

    private String testCase;

    private String tester;

    private String testResult;
    
}
