package com.example.demo.BirthDay;

import com.example.demo.Dto.DayDto;
import com.example.demo.Dto.EntityDto.AccountDto;
import com.example.demo.Dto.EntityDto.AccountFullNameDto;
import com.example.demo.Entity.Account;
import com.example.demo.Repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Component
public class BirthDaySource {
    @Autowired
    AccountRepo accountRepo;
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;
    @Autowired
    BirthDayPublisher birthDayPublisher;
    @Autowired
    BirthDayListener birthDayListener;

    //  @Scheduled(cron = "40 16 18 * * ?")
   // @Scheduled(fixedDelay = 5000)
    public void checkBirthDayAllAccount() throws InterruptedException {
        Date dateOfBirth = new Date();
        DayDto dayDto = new DayDto(dateOfBirth);
        List<AccountDto> accountList = accountRepo.findAccountDtoByDayOfBirth(dayDto.getDay(), dayDto.getMonth() + 1);
//        for (AccountDto a :
//             accountList) {
//            System.out.println(a.toString());
//        }
        if (CollectionUtils.isEmpty(accountList)) {
            return;
        }
        for (AccountDto accountDto : accountList) {
//            applicationEventPublisher.publishEvent(accountDto);
            for (int i = 0; i < 100; i++) {
//                birthDayPublisher.birthDayPublish(accountDto.getId());
                //birthDayListener.birthDayListener(new BirthDayEvent(this, 1));
            }

        }
    }
//    2
//    @Autowired
//    AccountRepo accountRepo;
//    @Autowired
//    BirthDayPublisher birthDayPublisher;
//
//    @Scheduled(cron = "0 55 11 * * ?")
//    public void checkBirthDayAllAccount() {
//        Date dateOfBirth = new Date();
//        DayDto dayDto= new DayDto(dateOfBirth);
//        List<Account> accountList =accountRepo.findAccountByDayOfBirth(dayDto.getDay(),dayDto.getMonth()+1);
//
//        for (Account account : accountList) {
//            birthDayPublisher.birthDayPublish(account.getId());
//        }
//    }
}
