package com.example.demo.Service;

import com.example.demo.Entity.RelatedUser;
import com.example.demo.Repository.ListUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListUserService {
    @Autowired
    ListUserRepo listUserRepo;

    public List<RelatedUser> getListUser() {
        return listUserRepo.findAll();
    }

    public void createListUser() {

    }

    public void editListUser() {

    }

    public void deleteListUser() {

    }

}
