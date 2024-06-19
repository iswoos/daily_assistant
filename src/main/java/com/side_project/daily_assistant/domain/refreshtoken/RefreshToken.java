//package com.side_project.daily_assistant.domain.refreshtoken;
//
//import com.side_project.daily_assistant.domain.BaseEntity;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//@Getter
//@Entity
//@NoArgsConstructor
//public class RefreshToken extends BaseEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String refreshToken;
//
//    private String userId;
//
//    public RefreshToken(String token, String userId) {
//        this.refreshToken = token;
//        this.userId = userId;
//    }
//
//    public RefreshToken updateToken(String token) {
//        this.refreshToken = token;
//        return this;
//    }
//
//}
