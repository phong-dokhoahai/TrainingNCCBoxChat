package com.example.demo.Service;

import com.example.demo.Entity.Account;
import com.example.demo.Entity.Conversation;
import com.example.demo.Entity.ConversationType;
import com.example.demo.Repository.ConversationRepo;
import com.example.demo.dto.AccountDto;
import com.example.demo.dto.ConversationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConversationService {
    @Autowired
    private ConversationRepo conversationRepo;
    // CRUD
    public List<Conversation> getConversation() {
        return conversationRepo.findAll();
    }
    // create a conversation when create account
    public void createPersonConversation(AccountDto accountDto) {
       Conversation conversation = new Conversation();

       conversation.setConversationName(accountDto.getAccountNickName());
       conversation.setConversationType(ConversationType.PERSON);
       conversation.setNumPeople(1);

       conversationRepo.save(conversation);
    }
    public void createGroupConversation(ConversationDto conversationDto){
        Conversation conversation = new Conversation();
        conversation.setConversationType(ConversationType.GROUP);
        conversation.setConversationName(conversationDto.getConversationName());
        conversationRepo.save(conversation);
    }
    public void deleteConversation(ConversationDto conversationDto){
        conversationRepo.deleteById(conversationDto.getConversation_ID());
    }
    public void editConversationName(ConversationDto conversationDto){
       Optional<Conversation> conversationOptional= conversationRepo.findById(conversationDto.getConversation_ID());
       Conversation conversation = conversationOptional.get();
       conversation.setConversationName(conversationDto.getConversationName());
    }
}
