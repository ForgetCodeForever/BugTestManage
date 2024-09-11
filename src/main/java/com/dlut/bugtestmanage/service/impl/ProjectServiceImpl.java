package com.dlut.bugtestmanage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dlut.bugtestmanage.entity.Project;
import com.dlut.bugtestmanage.mapper.ProjectMapper;
import com.dlut.bugtestmanage.service.ProjectService;
import org.springframework.stereotype.Service;

/**
 * (Project)表服务实现类
 *
 * @author makejava
 * @since 2024-09-10 19:07:15
 */
@Service("projectService")
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {

}
