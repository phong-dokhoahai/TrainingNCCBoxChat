package com.example.demo.controller;

import com.example.demo.Entity.Account;
import com.example.demo.Service.AccountService;
import com.example.demo.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AccountControll {

    @Autowired
    AccountService accountService;
    @GetMapping("/account") // get all account
    public ResponseEntity<List<Account>> getAccounts()
          //  @RequestParam("email")String email)
    {

        List<Account> accounts = accountService.getAccounts();

//        List<AccountDto> accountDtos = accounts.stream().map(o ->
//                new AccountDto().setUser_ID(o.getUser_ID())
//                        .setAccountName(o.getAccountName())
//                        .setAccountNote(o.getAccountNote())
//                        .setAccountPassword(o.getAccountPassword())
//                        .setAccountNickName(o.getAccountNickName())
//                        .setUserName(o.getUserName())
//                        .setUserBorn(o.getUserBorn())).collect(Collectors.toList());

        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @PostMapping("/account") // create account
    public void createAccount(@RequestBody AccountDto accountDto) {
        accountService.createAccount(accountDto);
    }

    @PatchMapping("/account")// edit account
    public void EditAccount(@RequestBody AccountDto accountDto) {
        accountService.editAccount(accountDto);
    }

    @DeleteMapping("/account")// delete account
    public void deleteAccount(@RequestBody AccountDto accountDto) {
        accountService.deleteAccount(accountDto);
    }

    @PatchMapping("/account/admin")// check admin
    public void isAdmin(@RequestBody AccountDto accountDto) {
        accountService.isAdmin(accountDto);
    }

    @GetMapping("/account/admin")// get all Admin Account
    public ResponseEntity<List<Account>> getAdminAccount(@RequestBody AccountDto accountDto) {
        List<Account> accounts = accountService.getAdminAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
}
