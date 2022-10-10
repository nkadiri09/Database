package com.example.database.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataBaseConfig {

    @Primary
    @Bean("restApi")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource createDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dbUserService")
    @ConfigurationProperties(prefix = "spring.userdatasource")
    public DataSource createUserServiceDataSource() {
        return DataSourceBuilder.create().build();
    }
}
