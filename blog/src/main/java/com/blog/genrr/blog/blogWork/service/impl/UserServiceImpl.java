package com.blog.genrr.blog.blogWork.service.impl;

import com.blog.genrr.blog.blogWork.dto.RegistBody;
import com.blog.genrr.blog.blogWork.entity.User;
import com.blog.genrr.blog.blogWork.mapper.UserMapper;
import com.blog.genrr.blog.blogWork.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Genrr
 * @since 2021-04-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    UserMapper userMapper;

    @Resource
    PasswordEncoder passwordEncoder;

    @Override
    public boolean regist(RegistBody registBody) {
        User user = new User();
        user.setName(registBody.getUsername());
        user.setPwd(passwordEncoder.encode(registBody.getPassword()));
        if (userMapper.insert(user)>0){
            return true;
        }
        return false;
    }
}
