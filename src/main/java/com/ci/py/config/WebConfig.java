/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci.py.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Miguel Mendoza
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"com.ci.py.config"})
public class WebConfig implements WebMvcConfigurer {
    
    @Primary
    @Bean(name = "dataSourcePropertiesPrimary")
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties stlmtDataSourceProperties(){
        return new DataSourceProperties();
    }
    
    @Primary
    @Bean(name = "dataSourcePostgresql")
    @Qualifier("dataSourcePostgresql")
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource(){
        return stlmtDataSourceProperties().initializeDataSourceBuilder().build();
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
