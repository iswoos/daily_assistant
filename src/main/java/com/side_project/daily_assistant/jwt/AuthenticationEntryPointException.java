//package com.side_project.daily_assistant.jwt;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//import java.io.IOException;
//
//@Component
//public class AuthenticationEntryPointException implements AuthenticationEntryPoint {
//
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response,
//                         AuthenticationException authException) throws IOException {
//        response.setContentType("application/json;charset=UTF-8");
//        response.getWriter().println(
//                new ObjectMapper().writeValueAsString(
//                        ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                )
//        );
//        response.setStatus(HttpStatus.UNAUTHORIZED.value());
//    }
//}
