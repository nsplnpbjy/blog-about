package com.blog.genrr.blog.blogWork.controller;


import com.blog.genrr.blog.blogWork.dto.RegistBody;
import com.blog.genrr.blog.blogWork.dto.ResponseData;
import com.blog.genrr.blog.blogWork.mapper.UserMapper;
import com.blog.genrr.blog.blogWork.service.IUserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Genrr
 * @since 2021-04-05
 */
@RestController
@RequestMapping("/blogWork/user")
public class UserController {

    @Resource
    IUserService iUserService;

    @PostMapping("/regist")
    public ResponseData regist(@RequestBody @Validated RegistBody registBody){
        if (iUserService.regist(registBody)){
            return ResponseData.good(null);
        }
        return ResponseData.bad(null);
    }
}
