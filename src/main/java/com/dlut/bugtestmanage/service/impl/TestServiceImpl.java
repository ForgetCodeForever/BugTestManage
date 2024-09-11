package com.dlut.bugtestmanage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dlut.bugtestmanage.entity.Test;
import com.dlut.bugtestmanage.mapper.TestMapper;
import com.dlut.bugtestmanage.service.TestService;
import org.springframework.stereotype.Service;

/**
 * (Test)表服务实现类
 *
 * @author makejava
 * @since 2024-09-10 19:10:36
 */
@Service("testService")
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {

}
