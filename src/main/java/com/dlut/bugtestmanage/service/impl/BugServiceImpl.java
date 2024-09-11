package com.dlut.bugtestmanage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dlut.bugtestmanage.entity.Bug;
import com.dlut.bugtestmanage.mapper.BugMapper;
import com.dlut.bugtestmanage.service.BugService;
import org.springframework.stereotype.Service;

/**
 * (Bug)表服务实现类
 *
 * @author makejava
 * @since 2024-09-10 19:01:37
 */
@Service("bugService")
public class BugServiceImpl extends ServiceImpl<BugMapper, Bug> implements BugService {

}
