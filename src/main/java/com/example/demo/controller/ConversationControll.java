package com.example.demo.controller;

import com.example.demo.Entity.Account;
import com.example.demo.Entity.Conversation;
import com.example.demo.Service.ConversationService;
import com.example.demo.dto.AccountDto;
import com.example.demo.dto.ConversationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConversationControll {
    @Autowired
    ConversationService conversationService;
    @GetMapping("/conversation")
    public ResponseEntity<List<Conversation>> getAccounts() {
        List<Conversation> conversation = conversationService.getConversation();
        return new ResponseEntity<>(conversation, HttpStatus.OK);
    }
    @PostMapping("/conversation") // create account
    public void createGroupConversation(@RequestBody ConversationDto conversationDto) {
        conversationService.createGroupConversation(conversationDto);
    }

    @PatchMapping("/conversation")// edit account
    public void EditAccount(@RequestBody ConversationDto conversationDto) {
         conversationService.editConversationName(conversationDto);
    }

    @DeleteMapping("/conversation")// delete account
    public void deleteAccount(@RequestBody ConversationDto conversationDto) {
        conversationService.deleteConversation(conversationDto);
    }
}
