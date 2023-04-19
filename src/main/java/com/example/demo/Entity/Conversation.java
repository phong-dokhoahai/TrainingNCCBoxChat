package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long conversation_ID;

    @Column(name = "conversationName")
    private String conversationName;

    @Column(name = "numPeople")
    private Integer numPeople;

    @Column(name = "conversationType")
    @Enumerated(EnumType.STRING)
    private ConversationType conversationType ;

    //Relation to Content
    @OneToMany(mappedBy = "conversation", fetch = FetchType.LAZY)
    private List<Content> content;
    //Relation to Account
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "account_conversation",
            joinColumns = @JoinColumn(name = "conversation_ID"),
            inverseJoinColumns = @JoinColumn(name = "user_ID"))
    private List<Account> accountC;
}

