package com.blog.genrr.oauthcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class OauthcenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthcenterApplication.class, args);
    }

}
