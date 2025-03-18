package com.example.demo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.ChatMessage;

@Controller
public class ChatController {

    @MessageMapping("/chat")  // Nhận tin nhắn từ client gửi lên "/app/chat"
    @SendTo("/topic/messages")  // Gửi tin nhắn đến tất cả client đang subcribe "/topic/messages"
    public ChatMessage send(ChatMessage message) {
    	//System.out.println("📩 Nhận tin nhắn từ client: " + message.getContent());
        return message; // Trả về tin nhắn để gửi đến tất cả client
    }
    
    @GetMapping("/chatpage")
    public String chatPage() {
        return "index";  
    }
}
