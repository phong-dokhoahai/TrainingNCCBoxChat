package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_ID;
    @Column(name = "account_name")
    private String accountName;
    @Column(name = "account_password")
    private String accountPassword;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_born")
    private Date userBorn;
    @Column(name = "account_note")
    private String accountNote;
    @Column(name = "account_nickname")
    private String accountNickName;
    @Column(name = "Admin")
    private boolean admin;

    @ManyToMany(mappedBy = "users",fetch = FetchType.LAZY)
    private List<ListUser> listUser;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private List<Report> reports;

    @ManyToMany(mappedBy = "accountC", fetch = FetchType.LAZY)
    private List<Conversation> conversation;
}
