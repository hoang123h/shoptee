package com.shoptee.shoptee.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
   /* @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home/index");
        registry.addViewController("/category").setViewName("category/category");
        registry.addViewController("/product").setViewName("product/product");
        registry.addViewController("/users").setViewName("home/users");
    }*/
}
