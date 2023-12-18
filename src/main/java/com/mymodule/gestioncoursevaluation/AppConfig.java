package com.mymodule.gestioncoursevaluation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public GlobalVariables globalVariables(){
        return new GlobalVariables();
    }
}
