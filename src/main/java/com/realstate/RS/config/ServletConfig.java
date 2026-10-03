package com.realstate.RS.config;

import com.realstate.RS.servlet.PropertyServlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean<PropertyServlet> propertyServlet() {

        ServletRegistrationBean<PropertyServlet> registration =
                new ServletRegistrationBean<>(
                        new PropertyServlet(),
                        "/servlet/properties"
                );

        return registration;
    }
}