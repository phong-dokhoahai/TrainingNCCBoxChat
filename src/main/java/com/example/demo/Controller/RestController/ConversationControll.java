package com.example.demo.Controller.RestController;

import com.example.demo.Dto.EntityDto.ConversationContentDto;
import com.example.demo.Entity.Conversation;
import com.example.demo.Service.ConversationService;
import com.example.demo.Dto.EntityDto.ConversationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conversation")
public class ConversationControll {
    @Autowired
    ConversationService conversationService;

    @GetMapping("/get")
    public ResponseEntity<List<Conversation>> getConversation() {
        List<Conversation> conversation = conversationService.getConversation();
        return new ResponseEntity<>(conversation, HttpStatus.OK);
    }

    @PostMapping("/create-group") // create conversation
    public void createGroupConversation(@RequestBody String name) {//(@RequestBody ConversationDto conversationDto) {
        conversationService.createGroupConversation(name);
    }

    @PostMapping("/sendmessage")
    public void conversationSendMessage(@RequestBody String message, @RequestHeader(name = "token") String token) {
    }

    @PatchMapping("/edit-name")// edit conversation
    public void EditConversation(@RequestBody ConversationDto conversationDto) {
        conversationService.editConversationName(conversationDto);
    }

    @DeleteMapping("/delete")// delete conversation
    public void deleteConversation(@RequestBody long id) {
        conversationService.deleteConversation(id);
    }
    @GetMapping("/content")
    public ResponseEntity<List<ConversationContentDto>> findAllContentByConversation(){
        List<ConversationContentDto> conversationContentDtoList =conversationService.findAllContentByConversation();
        return ResponseEntity.ok(conversationContentDtoList);
    }
}
