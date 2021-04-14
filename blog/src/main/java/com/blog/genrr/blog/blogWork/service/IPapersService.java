package com.blog.genrr.blog.blogWork.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blog.genrr.blog.blogWork.entity.Papers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.genrr.blog.blogWork.exceptionType.NonSearchResultException;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Genrr
 * @since 2021-04-08
 */
public interface IPapersService extends IService<Papers> {
    public IPage getPapers(long current, int offset) throws NonSearchResultException;

    public IPage searchPapers(String searchVal);
}
