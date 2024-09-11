package com.dlut.bugtestmanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dlut.bugtestmanage.ResponseResult;
import com.dlut.bugtestmanage.entity.Role;
import com.dlut.bugtestmanage.entity.User;
import com.dlut.bugtestmanage.enums.AppHttpCodeEnum;
import com.dlut.bugtestmanage.exception.SystemException;
import com.dlut.bugtestmanage.mapper.RoleMapper;
import com.dlut.bugtestmanage.mapper.UserMapper;
import com.dlut.bugtestmanage.service.UserService;
import com.dlut.bugtestmanage.utils.BeanCopyUtils;
import com.dlut.bugtestmanage.utils.PasswordEncoder;
import com.dlut.bugtestmanage.vo.UserRegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2024-09-10 19:12:25
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public ResponseResult register(User user) {
        // 对数据进行进行非空判断
        if (!StringUtils.hasText(user.getUsername())) {
            throw new SystemException(AppHttpCodeEnum.USERNAME_NOT_NULL);
        }
        if (!StringUtils.hasText(user.getPassword())) {
            throw new SystemException(AppHttpCodeEnum.PASSWORD_NOT_NULL);
        }
        if (!StringUtils.hasText(user.getRole())) {
            throw new SystemException(AppHttpCodeEnum.ROLETYPE_NOT_NULL);
        }
        String email, phoneNumber;
        if (StringUtils.hasText(user.getEmail())) {
            email = user.getEmail();
            user.setEmail(email);
        }
        if (StringUtils.hasText(user.getPhoneNumber())) {
            phoneNumber = user.getPhoneNumber();
            user.setPhoneNumber(phoneNumber);
        }

        // 获取用户输入的密码
        String password = user.getPassword();
        // 获取用户的用户名作为盐值
        String salt = user.getUsername();
        // 对密码进行加密（加盐的MD5）
        String encryptedPassword = PasswordEncoder.encodePassword(password, salt);
        user.setPassword(encryptedPassword);

        // 设置roleId
        LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Role::getRoleName, user.getRole());
        Role role = roleMapper.selectOne(queryWrapper);
        if (role == null) {
            throw new SystemException(AppHttpCodeEnum.ROLETYPE_NOT_EXISTS);
        }
        user.setRoleId(role.getRoleId());

        if (userNameExist(user.getUsername())) {
            return ResponseResult.errorResult(AppHttpCodeEnum.USER_EXISTS);
        } else {
            // 用户不存在，将用户信息存入用户数据库
            save(user);

            // 封装返回数据
            UserRegisterVo userRegisterVo = BeanCopyUtils.copyBean(user, UserRegisterVo.class);
            return ResponseResult.okResult(userRegisterVo);
        }
    }

    public boolean userNameExist(String username) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username);
        return  count(queryWrapper) > 0;
    }
}
