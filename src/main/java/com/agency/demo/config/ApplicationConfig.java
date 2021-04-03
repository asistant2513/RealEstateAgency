package com.agency.demo.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import java.util.Arrays;

@Configuration
public class ApplicationConfig {

    @Bean
    public FilterRegistrationBean hiddenHttpMethodFilter(){
        FilterRegistrationBean filter = new FilterRegistrationBean(new HiddenHttpMethodFilter());
        filter.setUrlPatterns(Arrays.asList("/*"));
        return filter;
    }
}
