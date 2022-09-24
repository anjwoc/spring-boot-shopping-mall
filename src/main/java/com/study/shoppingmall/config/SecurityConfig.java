package com.study.shoppingmall.config;

import com.study.shoppingmall.config.auth.jwt.JwtAuthenticationFilter;
import com.study.shoppingmall.config.auth.jwt.JwtAuthorizationFilter;
import com.study.shoppingmall.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserRepository userRepository;
    private final CorsConfig corsConfig;

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .formLogin().disable()
            .httpBasic().disable()
            .apply(new CustomFilterDsl())
            .and()
//                .antMatcher("/h2-console/**").permitAll
            .authorizeHttpRequests(auth ->
                {
                    try {
                        auth
                            .mvcMatchers("/h2-console/", "/h2-console/**")
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
        );
        // .httpBasic(Customizer.withDefaults())

        http.headers().frameOptions().disable();

        return http.build();
    }

    public class CustomFilterDsl extends AbstractHttpConfigurer<CustomFilterDsl, HttpSecurity> {
        @Override
        public void configure(HttpSecurity http) throws Exception {
            AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);

            http
                .addFilter(corsConfig.corsFilter())
                .addFilter(new JwtAuthenticationFilter(authenticationManager))
                .addFilter(new JwtAuthorizationFilter(authenticationManager, userRepository));
        }
    }



}
