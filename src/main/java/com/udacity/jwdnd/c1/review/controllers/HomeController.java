package com.udacity.jwdnd.c1.review.controllers;

import com.udacity.jwdnd.c1.review.model.MessageForm;
import com.udacity.jwdnd.c1.review.services.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private MessageService messageService;

    public HomeController(MessageService messageService){
        this.messageService = messageService;
    }
    @GetMapping("/home")
    public String getHomePage(@ModelAttribute("newMessage") MessageForm newMessage, Model model) {
        model.addAttribute("greetings", this.messageService.getMessages());
        return "home";
    }

    @PostMapping("/home")
    public String addMessage(@ModelAttribute("newMessage") MessageForm messageForm, Model model){
        messageService.addMessage(messageForm.getText());
        model.addAttribute("greetings", messageService.getMessages());
        messageForm.setText("");
        return "home";
    }
}
