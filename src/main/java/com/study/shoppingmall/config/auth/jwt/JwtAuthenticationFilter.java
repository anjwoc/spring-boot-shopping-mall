package com.study.shoppingmall.config.auth.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.shoppingmall.config.auth.common.PrincipalDetails;
import com.study.shoppingmall.dto.LoginRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        ObjectMapper om = new ObjectMapper();
        LoginRequestDto loginRequestDto = null;

        logger.info("JwtAuthenticationFilter: 진입");

        try {
            loginRequestDto = om.readValue(request.getInputStream(), LoginRequestDto.class);
        }catch(Exception e) {
            logger.error(e.getStackTrace());
        }

        logger.info("JwtAuthenticationFilter: " + loginRequestDto);

        // Generate Username and token

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                loginRequestDto.getUesrname(),
                loginRequestDto.getPassword()
        );

        logger.info("JwtAuthenticationFilter: 토큰 생성 완료");
        logger.info("JwtAuthenticationToken: " + token);

        Authentication authentication = authenticationManager.authenticate(token);
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        logger.info("Authentication: " + principal.getUser().getUsername());

        return authentication;
    }

    // JWT Token 생성 후 response에 넣는 부분
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        PrincipalDetails principalDetails = (PrincipalDetails) authResult.getPrincipal();
        String token = JWT.create()
                .withSubject(principalDetails.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
                .withClaim("id", principalDetails.getUser().getId())
                .withClaim("username", principalDetails.getUser().getUsername())
                .sign(Algorithm.HMAC512(JwtProperties.SECRET));

        response.addHeader(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + token);
    }
}
