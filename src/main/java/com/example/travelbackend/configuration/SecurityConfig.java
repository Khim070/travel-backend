package com.example.travelbackend.configuration;

import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers(
                                        "api/user/**",
                                        "api/user/login",
                                        "api/menubar/**",
                                        "api/headerbackground/**",
                                        "api/reviewheader/**",
                                        "api/reviewfirstsection/**",
                                        "api/card/**",
                                        "api/contactusheader/**",
                                        "api/contactusdetail/**",
                                        "api/ourteam/**",
                                        "api/aboutUs/**",
                                        "/image/**"
                                ).permitAll()
                                .requestMatchers("/api/**").authenticated()
                                .anyRequest().authenticated()
                ).formLogin(formLogin ->
                        formLogin
                                .loginPage("/login").permitAll()
                                .defaultSuccessUrl("/home", true)
                )
                .logout(logout ->
                        logout.permitAll()
                ).sessionManagement(sessionManagement ->
                        sessionManagement
                                .invalidSessionUrl("/login?invalid-session=true")
                                .maximumSessions(1)
                                .expiredUrl("/login?session-expired=true")
                )
                .csrf(csrf -> csrf.disable());

        return http.build();
    }

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }
}