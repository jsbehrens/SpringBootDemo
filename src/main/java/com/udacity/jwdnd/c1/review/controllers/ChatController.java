package com.udacity.jwdnd.c1.review.controllers;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.services.ChatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChatController {

    ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/chat")
    public String getChat(@ModelAttribute("newChat") ChatForm newChat, Model model){
        model.addAttribute("chatMessages", this.chatService.getMessages());
        return "chat";
    }

    @PostMapping("/chat")
    public String addChat(@ModelAttribute("newChat") ChatForm chatForm, Model model){
        chatService.addMessage(chatForm.getText(), chatForm.getUsername());
        model.addAttribute("chatMessages", this.chatService.getMessages());
        chatForm.setText("");
        chatForm.setUsername("");
        return "chat";
    }
}
