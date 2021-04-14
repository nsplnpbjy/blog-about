package com.blog.genrr.blog.blogWork.service;

import com.blog.genrr.blog.blogWork.dto.RegistBody;
import com.blog.genrr.blog.blogWork.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Genrr
 * @since 2021-04-05
 */
public interface IUserService extends IService<User> {

    public boolean regist(RegistBody registBody);
}
