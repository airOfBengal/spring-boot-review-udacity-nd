package com.udacity.jwdnd.c1.review.models;

public class ChatMessage {
    private Integer messageid;
    private String username;
    private String messagetext;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessagetext() {
        return messagetext;
    }

    public void setMessagetext(String messagetext) {
        this.messagetext = messagetext;
    }

    public Integer getMessageid() {
        return messageid;
    }

    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    @Override
    public String toString() {
        return
                "Username: " + username +
                ", message: " + messagetext;
    }

}
