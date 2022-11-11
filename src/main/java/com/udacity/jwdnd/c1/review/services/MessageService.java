package com.udacity.jwdnd.c1.review.services;

import com.udacity.jwdnd.c1.review.models.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private List<ChatMessage> messages;

    @PostConstruct
    public void init(){
        this.messages = new ArrayList<>();
    }

    public void addMessage(ChatMessage chatMessage){
        messages.add(chatMessage);
    }

    public ArrayList<ChatMessage> getMessages(){
        return new ArrayList<>(this.messages);
    }
}
