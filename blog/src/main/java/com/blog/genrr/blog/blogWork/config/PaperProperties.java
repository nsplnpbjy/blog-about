package com.blog.genrr.blog.blogWork.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author nsplnpbjy
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "paper")
public class PaperProperties {
    private String marxUrl;
    private String leninUrl;
    private String maoUrl;
    private boolean isActive;
}
