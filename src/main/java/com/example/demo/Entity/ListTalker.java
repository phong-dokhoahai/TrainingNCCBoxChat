package com.example.demo.Entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class ListTalker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long listTalker_ID;
    @Column(name = "listFriend")
    private static List<Account> listFriend;
    @Column(name = "listBlock")
    private static List<Account> listBlock;
    @Column(name = "listStranger")
    private static List<Account> listStranger;
    @ManyToOne
    private List<Account> users;

}
