package com.blog.genrr.blog.blogWork.schdule;

import com.blog.genrr.blog.blogWork.config.PaperProperties;
import com.blog.genrr.blog.blogWork.mapper.PapersMapper;
import com.blog.genrr.blog.blogWork.utils.PaperGetterUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author nsplnpbjy
 */
@Slf4j
@Component
@EnableAsync
@EnableConfigurationProperties(PaperProperties.class)
@ConditionalOnProperty(prefix = "paper",name = "isActive",havingValue = "true")
public class PaperGetter {

    @Resource
    PapersMapper papersMapper;

    @Resource
    PaperProperties paperProperties;

    @Async
    @Scheduled(initialDelay = 1000,fixedRate = 2678400000L)
    public void getPaperOfMarx(){
        if (paperProperties.getMarxUrl()==null) {
            log.warn("马克思著作网址为空");
            return;
        }
        PaperGetterUtil.paperGetter(papersMapper, paperProperties.getMarxUrl(),"马克思/恩格斯");
    }

    @Async
    @Scheduled(initialDelay = 1000,fixedRate = 2678400000L)
    public void getPaperOfLenin(){
        if (paperProperties.getLeninUrl()==null) {
            log.warn("列宁著作网址为空");
            return;
        }
        PaperGetterUtil.paperGetter(papersMapper, paperProperties.getLeninUrl(),"列宁");
    }


}
