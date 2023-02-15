package com.udacity.jwdnd.c1.review.services;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MessageService {
    private List<String> messages;

    @PostConstruct
    public void postConstruct() {
        this.messages = new ArrayList<>();
        System.out.println("Message service has been created.");
    }

    public void addMessage(String message) {
        messages.add(message);
    }

    public List<String> getMessages() {
        return new ArrayList<>(this.messages);
    }
}
