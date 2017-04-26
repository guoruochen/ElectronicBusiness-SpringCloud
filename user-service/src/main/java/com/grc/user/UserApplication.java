package com.grc.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author 郭若辰
 * @create 2017-02-25 21:10
 */
@SpringBootApplication
@EnableEurekaClient
public class UserApplication extends WebMvcConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    /**
     * 跨域问题
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").
                allowedMethods("DELETE", "POST", "GET", "PUT")
                .allowedOrigins("*");
    }
}
