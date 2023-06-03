package com.example.demo.Service;

import com.example.demo.Dto.EntityDto.ContentDto;
import com.example.demo.Repository.ConversationRepo;
import com.example.demo.Security.JwtUtils;
import com.example.demo.Entity.Account;
import com.example.demo.Entity.Content;
import com.example.demo.Entity.Conversation;
import com.example.demo.Repository.AccountRepo;
import com.example.demo.Repository.ContentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.example.demo.Demo.DemoJoinTable.ContentSpecifications.hasConversationId;

@Service
public class ContentService {
    @Autowired
    ContentRepo contentRepo;
    @Autowired
    AccountRepo accountRepo;
    @Autowired
    ConversationRepo conversationRepo;
    @Autowired
    JwtUtils jwtUtils;

    // CREATE
    public void sendContent(String message,
                            String token,
                            long conversationId) {

        Content content=new Content();
        content.setContentType(Content.ContentType.MESSAGE);
        content.setCreatedDate(new Date());
        content.setContent(message);

        String username=jwtUtils.getUserNameFromJwtToken(token);
        Account account = accountRepo.findByUsername(username);
        content.setNickName(account.getNickName());

        Conversation conversation = conversationRepo.findConversationById(conversationId);
        content.setConversation(conversation);
        contentRepo.save(content);
    }
    // READ
    public List<Content> getAllContent() {
        return contentRepo.findAll();
    }

    // UPDATE
    public void editContent() {

    }

    //DELETE
    public void deleteContent() {

    }
    public List<ContentDto> getContentByConversationId(long id){
       return contentRepo.findAllByConversationId(id);
    }
}
