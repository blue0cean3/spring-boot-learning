package com.luv2code.springboot.cruddemo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    // code by hand
    // @Bean
    // public InMemoryUserDetailsManager userDetailsManager() {
    // UserDetails viet = User.builder()
    // .username("viet")
    // .password("{noop}text1234")
    // .roles("admin", "manager", "employee")
    // .build();
    // UserDetails nam = User.builder()
    // .username("name")
    // .password("{noop}text123")
    // .roles("employee", "manager")
    // .build();
    // UserDetails hhe = User.builder()
    // .username("hehe")
    // .password("{noop}text12345")
    // .roles("employee")
    // .build();
    // return new InMemoryUserDetailsManager(viet, nam, hhe);

    // }

    // add support for JDBC
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");

        // define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer -> configurer
                .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN"));
        // use HTTP basic configuration
        http.httpBasic(Customizer.withDefaults());
        // disable Cross Site Request Forgery(CSRF)
        // In general, not required for stateless RestAPIs that use POST, PUT, DELETE or
        // PATH
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
