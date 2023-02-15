package com.udacity.jwdnd.c1.review.model;

public class ChatMessage {
    private String username;
    private String messageText;
    private String textType;
    private int messageid;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getTextType() {
        return textType;
    }

    public void setTextType(String textType) {
        this.textType = textType;
    }

    public int getMessageid() {
        return messageid;
    }

    public void setMessageid(int messageid) {
        this.messageid = messageid;
    }

    public String displayChatMessage(){
        String str = getUsername() + getMessageText();
        return str;
    }
}
