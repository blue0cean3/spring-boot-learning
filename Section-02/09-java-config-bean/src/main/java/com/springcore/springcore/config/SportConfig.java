package com.springcore.springcore.config;

import com.springcore.springcore.common.Coach;
import com.springcore.springcore.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
//    @Bean
    @Bean("aqua")   // custom bean ID to "aqua"
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
