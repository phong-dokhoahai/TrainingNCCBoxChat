package com.example.demo.controller.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long content_ID;
    @Column(name = "contentTime")
    private Date contentTime;
    @Column(name = "contentType")
    private ContentType contentType;
    @Column(name = "contentNickName")
    private Account contentNickName;
    @ManyToOne
    private Conversation conversation;



}
