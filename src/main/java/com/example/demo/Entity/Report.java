package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long report_ID;
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
