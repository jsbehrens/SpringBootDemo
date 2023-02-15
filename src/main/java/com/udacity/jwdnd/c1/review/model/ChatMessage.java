package com.udacity.jwdnd.c1.review.model;

public class ChatMessage {
    private String username;
    private String text;
    private int messageid;

    public ChatMessage(String un, String text, Integer messageid) {
        this.username = un;
        this.text = text;
        this.messageid = messageid;
    }

    public String getUsername(){
        return this.username;
    }

    public String getText(){
        return this.text;
    }

    public Integer getMessageid(){
        return this.messageid;
    }

    public String displayChatMessage(){
        String str = getUsername() + getText();
        return str;
    }
}
