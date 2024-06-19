//package com.side_project.daily_assistant.jwt.filter;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.side_project.daily_assistant.jwt.util.JwtUtil;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Slf4j
//@RequiredArgsConstructor
//public class JwtAuthFilter extends OncePerRequestFilter {
//
//    private final JwtUtil jwtUtil;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String accessToken = jwtUtil.getHeaderToken(request, "Access");
//
//        if (accessToken != null) {
//            if (!jwtUtil.validateToken(accessToken)) {
//                jwtExceptionHandler(response);
//                return;
//            }
//            setAuthentication(jwtUtil.getUserId(accessToken));
//        }
//
//        filterChain.doFilter(request, response);
//    }
//
//    public void setAuthentication(String userId) {
//        Authentication authentication = jwtUtil.createAuthentication(userId);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//    }
//
//    public void jwtExceptionHandler(HttpServletResponse response) throws IOException {
//        response.setContentType("application/json");
//        response.setCharacterEncoding("utf-8");
//        response.setStatus(HttpStatus.UNAUTHORIZED.value());
//        try {
//            String json = new ObjectMapper().writeValueAsString("TOKEN이 만료되었습니다");
//            response.getWriter().write(json);
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        }
//    }
//}
