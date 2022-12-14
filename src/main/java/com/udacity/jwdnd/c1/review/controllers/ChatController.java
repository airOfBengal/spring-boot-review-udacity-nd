package com.udacity.jwdnd.c1.review.controllers;

import com.udacity.jwdnd.c1.review.models.ChatForm;
import com.udacity.jwdnd.c1.review.models.ChatMessage;
import com.udacity.jwdnd.c1.review.services.MessageService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {
    private MessageService messageService;

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String getChat(@ModelAttribute("chatForm")ChatForm chatForm, Model model){
        model.addAttribute("messages", messageService.getMessages());
        return "chat";
    }

    @PostMapping
    public String setChat(Authentication auth, @ModelAttribute("chatForm")ChatForm chatForm, Model model){
        ChatMessage chatMessage = new ChatMessage();

        if(chatForm.getMessageType().equalsIgnoreCase("shout")){
            chatMessage.setMessagetext(chatForm.getMessage().toUpperCase());
            chatMessage.setUsername(auth.getName().toUpperCase());
        } else if (chatForm.getMessageType().equalsIgnoreCase("whisper")){
            chatMessage.setMessagetext(chatForm.getMessage().toLowerCase());
            chatMessage.setUsername(auth.getName().toLowerCase());
        } else {
            chatMessage.setMessagetext(chatForm.getMessage());
            chatMessage.setUsername(auth.getName());
        }
        messageService.addMessage(chatMessage);
        model.addAttribute("messages", messageService.getMessages());
        return "chat";
    }
}
