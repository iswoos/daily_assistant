//package com.side_project.daily_assistant.controller;
//
//import com.side_project.daily_assistant.dto.requestdto.LoginReqDto;
//import com.side_project.daily_assistant.dto.requestdto.MemberReqDto;
//import com.side_project.daily_assistant.dto.responsedto.MemberResDto;
//import com.side_project.daily_assistant.service.MemberService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//public class MemberController {
//
//    private final MemberService memberService;
//
//    @PostMapping("/members/signup")
//    public MemberResDto signup(@RequestBody MemberReqDto memberReqDto) {
//        return memberService.signup(memberReqDto);
//    }
//
//    @PostMapping("/members/login")
//    public MemberResDto login(@RequestBody LoginReqDto loginReqDto) {
//        return memberService.login(loginReqDto);
//    }
//}
