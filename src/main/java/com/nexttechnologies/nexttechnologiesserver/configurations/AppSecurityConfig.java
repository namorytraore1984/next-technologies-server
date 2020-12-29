package com.nexttechnologies.nexttechnologiesserver.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

   @Autowired
    public AppSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                //.antMatchers("/api/**").hasAnyRole("user")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails root = User.builder()
                .username("root")
                .password(passwordEncoder.encode("root"))
                .roles("user")
                .build();
        return new InMemoryUserDetailsManager(root);
    }
}
