package com.udacity.jwdnd.c1.review.services;

import com.udacity.jwdnd.c1.review.model.ChatMessage;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ChatService {
    private List<ChatMessage> messages;

    @PostConstruct
    public void postConstruct() {
        this.messages = new ArrayList<>();
        System.out.println("Chat service has been created.");
        System.out.println(messages);
    }

//    TODO: convert functions to used Message Mapper

    public void addMessage(String message, String username) {
        messages.add(new ChatMessage(username, message, null));
    }

    public List<ChatMessage> getMessages() {
        return new ArrayList<>(this.messages);
    }
}