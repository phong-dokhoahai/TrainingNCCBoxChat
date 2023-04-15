package com.example.demo.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "account_type")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_ID;
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
    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "Account_ID"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Conversation conversation;


}
