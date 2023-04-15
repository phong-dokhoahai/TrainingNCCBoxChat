package com.example.demo.controller.Entity;

import jakarta.persistence.*;

@Entity
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long conversation_ID;
    @Column(name = "conversationName")
    private String conversationName;
    @Column(name = "numPeople")
    private Integer numPeople;
    @Column(name = "conversationType")
    private ConversationType conversationType;
    @OneToMany
    private Content content;
    @ManyToMany
    private Account account;
}
