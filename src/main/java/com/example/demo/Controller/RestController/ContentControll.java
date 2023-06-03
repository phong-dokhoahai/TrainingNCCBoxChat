package com.example.demo.Controller.RestController;

import com.example.demo.Entity.Content;
import com.example.demo.Service.ContentService;
import com.example.demo.Dto.EntityDto.ContentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/content")
public class ContentControll {
    @Autowired
    ContentService contentService;

    @GetMapping("/show-all")
    public ResponseEntity<List<Content>> getContent() {
        List<Content> content = contentService.getAllContent();
        return new ResponseEntity<>(content, HttpStatus.OK);
    }

    @PostMapping("/send/{conversationId}") // create
    public void sendContent(@RequestBody String message,
                            @RequestHeader(name = "Authorization") String token,
                            @PathVariable long conversationId) {
        contentService.sendContent(message, token, conversationId);
    }
    @PatchMapping("/edit")// edit
    public void EditAccount(@RequestBody ContentDto contentDto) {
        contentService.editContent();
    }

    @DeleteMapping("/delete")// delete
    public void deleteAccount(@RequestBody ContentDto contentDto) {
        contentService.deleteContent();
    }
}
