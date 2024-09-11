package com.dlut.bugtestmanage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dlut.bugtestmanage.entity.ProjectModule;
import com.dlut.bugtestmanage.mapper.ProjectModuleMapper;
import com.dlut.bugtestmanage.service.ProjectModuleService;
import org.springframework.stereotype.Service;

/**
 * (ProjectModule)表服务实现类
 *
 * @author makejava
 * @since 2024-09-10 19:08:11
 */
@Service("projectModuleService")
public class ProjectModuleServiceImpl extends ServiceImpl<ProjectModuleMapper, ProjectModule> implements ProjectModuleService {

}
