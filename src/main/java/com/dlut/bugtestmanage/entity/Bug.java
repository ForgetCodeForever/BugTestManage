package com.dlut.bugtestmanage.entity;

import java.util.Date;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Bug)表实体类
 *
 * @author makejava
 * @since 2024-09-10 19:01:35
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("bug")
public class Bug  {
    
    @TableId
    private Integer bugId;


    private String bugName;

    private String bugContent;

    private Integer bugModule;

    private String bugBuilder;

    private Date bugCreateDate;

    private String bugReceiver;

    private Integer bugGrade;

    private String bugSolution;

    private Date bugSolvedDate;

    private String bugState;

    private Date closeDate;
    
}
