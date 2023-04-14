package com.example.demo.controller.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "account_type")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String user_ID;
    @Column(name = "accountName")
    private String accountName;
    @Column(name = "accountPassword")

    private String accountPassword;
    @Column(name = "userName")

    private String userName;
    @Column(name = "userBorn")

    private Date userBorn;
    @Column(name = "accountNote")
    private StringBuffer accountNote;
    @Column(name = "accountNickName")
    private String accountNickName;
    @OneToOne
    private ListTalker listTalker;
    @OneToMany(mappedBy = "account")
    private List<Report> reports;
    @ManyToMany
    private Conversation conversation;
    @Column(name = "type")
    private String type;

}
