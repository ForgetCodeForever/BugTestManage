package com.dlut.bugtestmanage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dlut.bugtestmanage.entity.UserProject;
import com.dlut.bugtestmanage.mapper.UserProjectMapper;
import com.dlut.bugtestmanage.service.UserProjectService;
import org.springframework.stereotype.Service;

/**
 * (UserProject)表服务实现类
 *
 * @author makejava
 * @since 2024-09-11 22:05:38
 */
@Service("userProjectService")
public class UserProjectServiceImpl extends ServiceImpl<UserProjectMapper, UserProject> implements UserProjectService {

}
