package com.example.demo.Service;

import com.example.demo.Demo.DemoRestTemplate.Employee;
import com.example.demo.Demo.DemoRestTemplate.RestTemplateBody;
import com.example.demo.Dto.EntityDto.AccountFullNameDto;
import com.example.demo.Entity.Account;

import com.example.demo.MapStruct.AccountMaper;
import com.example.demo.Repository.AccountRepo;
import com.example.demo.Dto.EntityDto.AccountDto;
import com.example.demo.Dto.EntityDto.AccountNamePasswordDTO;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AccountService {
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    ConversationService conversationService;
    @Autowired
    AccountConversationBrokerService accountConversationBrokerService;
    private AccountMaper accountMaper = Mappers.getMapper(AccountMaper.class);

   // @Cacheable(value = "getaccounts")
    public List<AccountDto> getAccounts() {
        List<Account> accounts = accountRepo.findAll();
        List<AccountDto> accountDtos = accounts.stream().map(account ->
                accountMaper.toDto(account)).collect(Collectors.toList());
        return accountDtos;
    }

    public List<AccountFullNameDto> getAccountsFullName(Date date) {
        return accountRepo.findAccountFullNameByDateOfBirth(date);
    }

    @Transactional
    public void createAccount(AccountNamePasswordDTO accountNamePasswordDTO) {
        Account account = accountMaper.toEntity(accountNamePasswordDTO);
        try {
//        Account account = new Account();
//        account.setUsername(accountNamePasswordDTO.getUsername());
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            account.setPassword(bCryptPasswordEncoder.encode(accountNamePasswordDTO.getPassword()));
            account.setNickName(accountNamePasswordDTO.getUsername());
            account.setRole(Account.Role.USER);
            accountRepo.save(account);
        } catch (Exception e) {
            System.out.println("Tài khoản đã tồn tại");
        }
        accountConversationBrokerService.create(account, conversationService.createConversationForPerson(accountMaper.toDto(account)));
    }

    @Async
    @Transactional
    public void createAccountByRestTemplate(RestTemplateBody restTemplateBody) {

        for (Employee e
                : restTemplateBody.getResult()) {
            Account account = new Account();
            try {
                account.setUsername(e.getEmail());
                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
                account.setPassword(bCryptPasswordEncoder.encode(e.getEmail().substring(0, e.getEmail().indexOf("@"))));
                account.setEmail(e.getEmail());
                account.setFirstName(e.getFirstName());
                account.setLastName(e.getLastName());
                account.setRole(Account.Role.USER);
                accountRepo.save(account);
            } catch (Exception exception) {
                System.out.println("Tài khoản đã tồn tại");
            }
            accountConversationBrokerService.create(account, conversationService.createConversationForPerson(accountMaper.toDto(account)));
        }
    }
    // Update Account
    public void editAccount(AccountDto accountDto) {
        Optional<Account> accountOptional = accountRepo.findById(accountDto.getId());
        try {
            Account account = accountOptional.get();
            account.setDateOfBirth(accountDto.getDateOfBirth());
            account.setAccountNote(accountDto.getAccountNote());
            account.setPhoneNumber(accountDto.getPhoneNumber());
            account.setNickName(accountDto.getNickName());
            account.setEmail(accountDto.getEmail());
//            Account newAccount = accountMaper.toEntity(accountDto);
//            account.setUsername(accountOptional.get().getUsername());
//            account.setPassword(accountOptional.get().getPassword());
//            accountRepo.save(account);
            accountRepo.saveAndFlush(account);
        } catch (Exception e) {
        }
    }

    public void deleteAccount(Long id) {
        accountRepo.deleteById(id);
    }
    public void updateAccountToAdmin(long id) {
        Account account = accountRepo.findAccountById(id);
        account.setRole(Account.Role.ADMIN);
        accountRepo.save(account);
    }
}
