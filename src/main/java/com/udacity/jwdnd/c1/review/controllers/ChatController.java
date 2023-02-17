package com.udacity.jwdnd.c1.review.controllers;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.services.MessageService;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChatController {

    MessageService messageService;

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/chat")
    public String getChat(@ModelAttribute("newChat") ChatForm newChat, Model model){
        model.addAttribute("chatMessages", this.messageService.getChatMessages());
        return "chat";
    }

    @PostMapping("/chat")
    public String addChat(@ModelAttribute("newChat") ChatForm chatForm, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        chatForm.setUsername(auth.getPrincipal().toString());
        messageService.addMessage(chatForm);
        model.addAttribute("chatMessages", this.messageService.getChatMessages());
        chatForm.setText("");
        return "chat";
    }

    @ModelAttribute("allMessageTypes")
    public String[] allMessageTypes () {
        return new String[] { "Say", "Shout", "Whisper" };
    }
}
