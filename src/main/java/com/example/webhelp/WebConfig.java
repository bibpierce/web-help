/*
package com.example.webhelp;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@EnableMethodSecurity
public class WebConfig {

    //default user and password for each role
    @Bean
    public InMemoryUserDetailsManager configure() throws Exception {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles("USER")
                .build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }
    @Bean
    public SecurityFilterChain employeeAndTicketsFilterChain(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .authorizeHttpRequests(request ->
                        request.requestMatchers("/employee/list",
                                        "/employee/view/**",
                                        "/ticket/list",
                                        "/ticket/view/**")
                                .permitAll()
                                .requestMatchers(HttpMethod.POST, "/employee/create",
                                        "/ticket/create")
                                .hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT,"/employee/update/**",
                                        "/ticket/update/**",
                                        "/employee/assign/**",
                                        "/employee/watchers/**")
                                .hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/employee/delete/**",
                                        "/api/ticket/delete/**")
                                .hasRole("ADMIN")
                                .anyRequest()
                                .authenticated())
                .httpBasic();
        return http.build();
    }

}
 */