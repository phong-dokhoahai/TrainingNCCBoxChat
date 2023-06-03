package com.example.demo.BirthDay;

import com.example.demo.Demo.DemoMail.Mail.MyConstants;
import com.example.demo.Dto.EntityDto.AccountDto;
import com.example.demo.Entity.Account;
import com.example.demo.MapStruct.AccountMaper;
import com.example.demo.Repository.AccountRepo;
import jdk.swing.interop.SwingInterOpUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BirthDayListener {
    //    @Autowired
//    public JavaMailSender emailSender;
//    private AccountMaper accountMaper = Mappers.getMapper(AccountMaper.class);
//    @Autowired AccountRepo accountRepo;
//    @EventListener
//    @Async
//    public void birthDayListener(AccountDto accountDto) throws InterruptedException {
//        System.out.println("birthDayListener1 :" + Thread.currentThread().getName());
////        Account account = accountRepo.findAccountById(birthDayEvent.getId());
//
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(accountDto.getEmail());
//        message.setSubject("Happy Birthday Email");
//        message.setText("Happy Birthday to you!" + accountDto.getFirstName() + " " + accountDto.getLastName());
//
//        this.emailSender.send(message);
//    }

    //    @Async
//    public void sendEmail(List<AccountDto> accounts) {
//        System.out.println("birthDayListener :"+Thread.currentThread().getName());
////        Account account = accountRepo.findAccountById(birthDayEvent.getId());
//        for (AccountDto accountDto: accounts) {
//            SimpleMailMessage message = new SimpleMailMessage();
//            message.setTo(accountDto.getEmail());
//            message.setSubject("Happy Birthday Email");
//            message.setText("Happy Birthday to you!"+accountDto.getFirstName()+" "+accountDto.getLastName());
//            // Send Message!
//            this.emailSender.send(message);
//        }
//    }
    @Autowired
    public JavaMailSender emailSender;
    private AccountMaper accountMaper = Mappers.getMapper(AccountMaper.class);
    @Autowired
    AccountRepo accountRepo;

    @EventListener
    @Async
    public void birthDayListener(BirthDayEvent birthDayEvent) throws InterruptedException {
//        Account account = accountRepo.findAccountById(birthDayEvent.getId());
//
//        System.out.println("birthDayListener2 :" + Thread.currentThread().getName());
//
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(account.getEmail());
//        message.setSubject("Happy Birthday Email");
//        message.setText("Happy Birthday to you!" + account.getFirstName() + " " + account.getLastName());
//        // Send Message!
//        this.emailSender.send(message);
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(100000);

    }
    @EventListener
    public void abcEvent(AnotherEvent anotherEvent) {
        System.out.println("this is another event !");
    }
}

