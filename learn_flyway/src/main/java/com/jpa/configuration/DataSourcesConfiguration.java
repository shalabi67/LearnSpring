package com.jpa.configuration;

import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by mshalabi on 04.08.17.
 */
@Configuration
public class DataSourcesConfiguration{
    @Bean
    @Primary
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @FlywayDataSource
    @ConfigurationProperties(prefix="datasource.flyway")
    public DataSource flywayDataSource(){
        return DataSourceBuilder.create().build();
    }
}

