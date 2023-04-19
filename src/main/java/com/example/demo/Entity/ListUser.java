package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class ListUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long listUser_ID;
    @Column(name = "list_user")
    @Enumerated(EnumType.STRING)
    private ListUserType listUserType;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "listuser_account", joinColumns = @JoinColumn(name = "listUser_ID"), inverseJoinColumns = @JoinColumn(name = "user_ID"))
    private List<Account> users;
}
enum ListUserType {
    listStranger,listBlock,listFriend
}

