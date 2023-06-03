package com.example.demo.Controller.RestController;

import com.example.demo.Entity.Account;
import com.example.demo.Repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class FetchTypeController {
    @Autowired
    AccountRepo accountRepo;
    @GetMapping("/account/report")
    public void getReport() {
        Account account=accountRepo.findAccountById(1);
//        List<Report> reportList = account.getReportList();
//
//        for (Report e:
//                reportList) {
//            System.out.println(e.getNickName());
//        }
//        return new ResponseEntity<>(reportList, HttpStatus.OK);
    }
}
