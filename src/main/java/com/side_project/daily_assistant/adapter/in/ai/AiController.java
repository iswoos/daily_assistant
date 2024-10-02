//package com.side_project.daily_assistant.adapter.in.ai;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.ai.openai.OpenAiChatModel;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequiredArgsConstructor
//public class AiController {
//    private final OpenAiChatModel openAiChatModel;
//
//    @GetMapping("/chat")
//    public Map<String, String> chat(@RequestBody String message) {
//        Map<String, String> responses = new HashMap<>();
//
//        String openAiReponse = openAiChatModel.call(message);
//        responses.put("응답", openAiReponse);
//        return responses;
//    }
//}
