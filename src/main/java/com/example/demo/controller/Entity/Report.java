package com.example.demo.controller.Entity;

import jakarta.persistence.*;

@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String report_ID;
    @Column(name = "reportType")
    private String reportType;
    @Column(name = "reportContent")
    private Content reportContent;
    @Column(name = "reportNickName")
    private String reportNickName;
    @ManyToOne
    @JoinColumn(name = "reportNickName", referencedColumnName = "accountNickName")
    private Account account;
}
