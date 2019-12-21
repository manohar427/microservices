package com.test;

import com.test.filter.ErrorFilter;
import com.test.filter.PostFilter;
import com.test.filter.PreFilter;
import com.test.filter.RouteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class EmployeeZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeZuulApplication.class, args);
    }

    @Bean
    public PreFilter getPreFilter() {
        return new PreFilter();
    }

    @Bean
    public PostFilter getPostFilter() {
        return new PostFilter();
    }

    @Bean
    public ErrorFilter getErrorFilter() {
        return new ErrorFilter();
    }

    @Bean
    public RouteFilter getRouteFilter() {
        return new RouteFilter();
    }
}
