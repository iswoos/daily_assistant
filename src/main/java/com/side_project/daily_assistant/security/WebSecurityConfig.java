//package com.side_project.daily_assistant.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//
//@Configuration
//class WebSecurityConfig {
//    @Bean
//    fun filterChain(http:HttpSecurity) = http
//            .csrf { it.disable() }
//        .headers { it.frameOptions { frameOptions -> frameOptions.sameOrigin() } }	// H2 콘솔 사용을 위한 설정
//        .authorizeHttpRequests {
//        it.requestMatchers("/", "/swagger-ui/**", "/v3/**").permitAll()	// requestMatchers의 인자로 전달된 url은 모두에게 허용
//                .requestMatchers(PathRequest.toH2Console()).permitAll()	// H2 콘솔 접속은 모두에게 허용
//                .anyRequest().authenticated()	// 그 외의 모든 요청은 인증 필요
//    }
//        .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }	// 세션을 사용하지 않으므로 STATELESS 설정
//        .build()!!
//}
