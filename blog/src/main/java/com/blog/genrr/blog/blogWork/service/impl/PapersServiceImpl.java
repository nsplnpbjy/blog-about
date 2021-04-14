package com.blog.genrr.blog.blogWork.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.genrr.blog.blogWork.entity.Papers;
import com.blog.genrr.blog.blogWork.exceptionType.NonSearchResultException;
import com.blog.genrr.blog.blogWork.mapper.PapersMapper;
import com.blog.genrr.blog.blogWork.service.IPapersService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Genrr
 * @since 2021-04-08
 */
@Service
public class PapersServiceImpl extends ServiceImpl<PapersMapper, Papers> implements IPapersService {

    @Resource
    PapersMapper papersMapper;

    @SneakyThrows
    @Override
    public IPage getPapers(long current,int offset)  {
        IPage iPage = papersMapper.selectPage(new Page<>(current,offset),new LambdaQueryWrapper<>());
        if (iPage.getRecords().isEmpty()){
            throw new NonSearchResultException("non search result",400);
        }
        return iPage;
    }

    @Override
    @SneakyThrows
    public IPage searchPapers(String searchVal) {
        IPage iPage = papersMapper.selectPage(new Page<>(0,200),new LambdaQueryWrapper<Papers>().like(Papers::getName,searchVal).or().like(Papers::getAuth,searchVal));
        if (iPage.getRecords().isEmpty()){
            throw new NonSearchResultException("non search result",400);
        }
        return iPage;
    }
}
