package com.udacity.jwdnd.c1.review.services;

import com.udacity.jwdnd.c1.review.data.MessageMapper;
import com.udacity.jwdnd.c1.review.models.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private List<ChatMessage> messages;
    private MessageMapper messageMapper;

    public MessageService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    @PostConstruct
    public void init(){
        this.messages = new ArrayList<>();
    }

    public void addMessage(ChatMessage chatMessage){
        messageMapper.insert(chatMessage);
    }

    public ArrayList<ChatMessage> getMessages(){
        return messageMapper.getAllMessage();
    }
}
