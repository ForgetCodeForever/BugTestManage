package com.dlut.bugtestmanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dlut.bugtestmanage.ResponseResult;
import com.dlut.bugtestmanage.entity.User;


/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2024-09-10 19:12:25
 */
public interface UserService extends IService<User> {

    ResponseResult register(User user);
}
