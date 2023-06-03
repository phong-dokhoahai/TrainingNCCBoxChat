package com.example.demo.Controller.RestController;

import com.example.demo.Dto.EntityDto.AccountFullNameDto;
import com.example.demo.Entity.Account;

import com.example.demo.Repository.AccountRepo;
import com.example.demo.Service.AccountService;
import com.example.demo.Dto.EntityDto.AccountDto;
import com.example.demo.Dto.EntityDto.AccountNamePasswordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/account")
public class AccountControll {

    @Autowired
    AccountService accountService;
    @Autowired
    AccountRepo accountRepo;

    @GetMapping// get all account
        public ResponseEntity<List<AccountDto>> getAccounts() {
        List<AccountDto> accountDtos = accountService.getAccounts();
        return new ResponseEntity<>(accountDtos, HttpStatus.OK);
    }

    @GetMapping("/projection") // get all account
    public ResponseEntity<List<AccountFullNameDto>> getAccountProjection(Date date) {
        List<AccountFullNameDto> accounts = accountService.getAccountsFullName(date);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable long id) {
        Account account = accountRepo.findAccountById(id);
        return ResponseEntity.ok(account);
    }

    @GetMapping("/note/{note}")
    ResponseEntity<List<Account>> getAccountById(@PathVariable String note) {
        List<Account> account = accountRepo.findAccountByAccountNote(note);
        System.out.println(account);
        return ResponseEntity.ok(account);
    }

    @GetMapping("/role")
    ResponseEntity<List<Account>> getAccountByRole(@RequestParam String role) {
        List<Account> account = accountRepo.findAccountByRole(Account.Role.valueOf(role));
        return ResponseEntity.ok(account);
    }

    @PostMapping(value = "/register",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void createAccount(@RequestBody AccountNamePasswordDTO accountNamePasswordDTO) {
        accountService.createAccount(accountNamePasswordDTO);
    }

    @PatchMapping("/information")// edit account
    public void EditAccount(@RequestBody AccountDto accountDto) {
        accountService.editAccount(accountDto);
    }

    @DeleteMapping("/{id}")// delete account
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }

    @PatchMapping("/{id}/admin")// check admin
    public void isAdmin(@PathVariable long id) {
        accountService.updateAccountToAdmin(id);
    }

//    @GetMapping("/nickname")
//    public ResponseEntity<List<AccountProjection>> findByNickname(@RequestBody String nickname) {
//    List<AccountProjection> accountList = accountService.findByNickName(nickname);
//        System.out.println(accountList);
//    return ResponseEntity.ok(accountList);
//    }
}
