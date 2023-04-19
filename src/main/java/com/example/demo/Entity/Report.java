package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long report_ID;
    @Column(name = "report_type")
    @Enumerated(EnumType.STRING)
    private ReportType reportType;
    @Column(name = "report_nickname")
    private String reportNickName;


    @OneToMany(mappedBy = "content_ID", fetch = FetchType.LAZY)
    private List<Content> reportContent;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_ID")
    private Account account;

}
enum ReportType {
    Toxic
}
