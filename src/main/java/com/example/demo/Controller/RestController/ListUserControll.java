package com.example.demo.Controller.RestController;

import com.example.demo.Entity.RelatedUser;
import com.example.demo.Service.ListUserService;
import com.example.demo.Dto.EntityDto.ListUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ListUserControll {
    @Autowired
    ListUserService listUserService;
    @GetMapping("/listUser")
    public ResponseEntity<List<RelatedUser>> getListUser() {
        List<RelatedUser> relatedUser = listUserService.getListUser();
        return new ResponseEntity<>(relatedUser, HttpStatus.OK);
    }
    @PostMapping("/listUser") // create
    public void createGroupListUser(@RequestBody ListUserDto ListUserDto) {
        listUserService.createListUser();
    }

    @PatchMapping("/listUser")// edit
    public void EditAccount(@RequestBody ListUserDto ListUserDto) {
        listUserService.editListUser();
    }

    @DeleteMapping("/listUser")// delete
    public void deleteAccount(@RequestBody ListUserDto ListUserDto) {
        listUserService.deleteListUser();
    }
}
