package com.side_project.general_board;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {

    @GetMapping("/")
    public String test1() {
        return "test1 통과하였습니다";
    }
}
