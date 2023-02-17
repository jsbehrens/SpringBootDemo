package com.udacity.jwdnd.c1.review.services;

import com.udacity.jwdnd.c1.review.mapper.MessageMapper;
import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final MessageMapper messageMapper;

    public MessageService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    public void addMessage(ChatForm chatForm) {
        ChatMessage newMessage = new ChatMessage();
        newMessage.setUsername(chatForm.getUsername());
        switch (chatForm.getType()) {
            case "Say":
                newMessage.setMessageText(chatForm.getText());
                break;
            case "Shout":
                newMessage.setMessageText(chatForm.getText().toUpperCase());
                break;
            case "Whisper":
                newMessage.setMessageText(chatForm.getText().toLowerCase());
                break;
        }
        this.messageMapper.insert(newMessage);
    }

    public List<ChatMessage> getChatMessages() {
        return this.messageMapper.getMessages();
    }
}
