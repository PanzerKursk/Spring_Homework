package ru.davydchenkov.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class TestSecurity extends SecurityConfigurerAdapter {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeRequests()
                .antMatchers("/private-data").hasRole("ADMIN")
                .antMatchers("/public-data").authenticated()
                .and()
                .formLogin()
                .and()
                .logout()
                .logoutSuccessUrl("/homepage").and().build();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user") .password("userpwd") .roles("USER") .build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin") .password("adminpwd") .roles("ADMIN") .build();
        return new InMemoryUserDetailsManager(user, admin);
    }
}
