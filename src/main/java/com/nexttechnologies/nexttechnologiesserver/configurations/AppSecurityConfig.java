package com.nexttechnologies.nexttechnologiesserver.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@NonNull
    private final PasswordEncoder passwordEncoder;
	@NonNull
    private final UserDetailsService appUserSerive;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/**").hasAnyRole("USER")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }
    
    // Creer l'authentication manager
    @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
    
    // Creer l'authentication provider
    @Bean
    public DaoAuthenticationProvider authenticationProvider( ) {
    	DaoAuthenticationProvider daoAuthProvider = new DaoAuthenticationProvider();
    	daoAuthProvider.setPasswordEncoder(passwordEncoder);
    	daoAuthProvider.setUserDetailsService(appUserSerive);
    	return daoAuthProvider;
    }

    /*@Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails root = User.builder()
                .username("root")
                .password(passwordEncoder.encode("root"))
                .roles("user")
                .build();
        return new InMemoryUserDetailsManager(root);
    }*/
}
