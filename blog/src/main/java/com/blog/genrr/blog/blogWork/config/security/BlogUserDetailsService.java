package com.blog.genrr.blog.blogWork.config.security;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.blog.genrr.blog.blogWork.entity.Role;
import com.blog.genrr.blog.blogWork.entity.RoleUser;
import com.blog.genrr.blog.blogWork.entity.User;
import com.blog.genrr.blog.blogWork.mapper.RoleMapper;
import com.blog.genrr.blog.blogWork.mapper.RoleUserMapper;
import com.blog.genrr.blog.blogWork.mapper.UserMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component("blogUserDetailsService")
public class BlogUserDetailsService implements UserDetailsService {

    @Resource
    UserMapper userMapper;

    @Resource
    RoleMapper roleMapper;

    @Resource
    RoleUserMapper roleUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isBlank(username)){
            throw new UsernameNotFoundException("username not found");
        }

        User user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getName,username));
        List<RoleUser> roleUserList = roleUserMapper.selectList(new LambdaQueryWrapper<RoleUser>().eq(RoleUser::getUserId,user.getId()));
        List<SimpleGrantedAuthority> roleList = new ArrayList<>();
        for (RoleUser roleUser :
                roleUserList) {
            Role role = roleMapper.selectById(roleUser.getRoleId());
            roleList.add(new SimpleGrantedAuthority(String.valueOf(role.getId())));
        }
        return new org.springframework.security.core.userdetails.User(user.getName(),user.getPwd(),roleList);
    }
}
