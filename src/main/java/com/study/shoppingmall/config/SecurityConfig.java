package com.study.shoppingmall.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final CorsConfig corsConfig;

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth ->
                {
                    try {
                        auth
                            .mvcMatchers("/**", "/h2-console", "/h2-console/**", "/users", "/users/**")
                            .permitAll()
                            .anyRequest()
                            .authenticated()
                            .and()
                            .csrf()
                                .ignoringAntMatchers("/h2-console")
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
