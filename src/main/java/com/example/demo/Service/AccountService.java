package com.example.demo.Service;

import com.example.demo.Entity.Account;
import com.example.demo.Repository.AccountRepo;
import com.example.demo.Repository.ConversationRepo;
import com.example.demo.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    ConversationService conversationService;

    //Read all Account
    public List<Account> getAccounts() {
        return accountRepo.findAll();
    }

    // Read all Admin Account
    public List<Account> getAdminAccounts() {
        return accountRepo.findByAdminTrue();
    }

    //Create Account
    public void createAccount(AccountDto accountDto) {
        Account account = new Account();

        account.setAccountName(accountDto.getAccountName());
        account.setAccountNote(accountDto.getAccountNote());
        account.setAccountPassword(accountDto.getAccountPassword());
        account.setAccountNickName(accountDto.getAccountNickName());
        account.setUserBorn(accountDto.getUserBorn());
        account.setUserName(accountDto.getUserName());
        account.setAdmin(false);

        accountRepo.save(account);
        // create a conversation when create account
        conversationService.createPersonConversation(accountDto);
    }

    // Update Account
    public void editAccount(AccountDto accountDto) {
        Optional<Account> accountOptional = accountRepo.findById(accountDto.getUser_ID());
        try {
            Account account = accountOptional.get();

            account.setAccountName(accountDto.getAccountName());
            account.setAccountNote(accountDto.getAccountNote());
            account.setAccountPassword(accountDto.getAccountPassword());
            account.setAccountNickName(accountDto.getAccountNickName());
            account.setUserBorn(accountDto.getUserBorn());
            account.setUserName(accountDto.getUserName());

            accountRepo.save(account);
        } catch (Exception e) {
        }
    }

    //Delete Account
    public void deleteAccount(AccountDto accountDto) {
        accountRepo.deleteById(accountDto.getUser_ID());
    }

    // Account is Admin use PACTH method
    public void isAdmin(AccountDto accountDto) {
        Optional<Account> accountOptional = accountRepo.findById(accountDto.getUser_ID());
        Account account = accountOptional.get();
        account.setAdmin(true);
        accountRepo.save(account);
    }
}
