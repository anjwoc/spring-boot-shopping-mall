package com.study.shoppingmall.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth ->
                {
                    try {
                        auth
                            .mvcMatchers("/", "/h2-console/**", "/users/*")
                            .permitAll()
                            .anyRequest()
                            .authenticated()
                            .and()
                            .csrf()
                                .ignoringAntMatchers("/h2-console/**")
                                .disable();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
        ).httpBasic(Customizer.withDefaults());

        http.headers().frameOptions().disable();

        return http.build();
    }

}
