package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long content_ID;
    @Column(name = "contentTime")
    private Date contentTime;
    @Column(name = "contentType")
    @Enumerated(EnumType.STRING)
    private ContentType contentType;
    @Column(name = "contentNickName")
    private String contentNickName;

    // Relation to Conversation Table
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="conversation_ID" )
    private Conversation conversation;

    //Relation to Report Table
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report_ID")
    private Report report;
}
enum ContentType {
    MESSAGE,VIDEO,IMAGE,FILE
}
