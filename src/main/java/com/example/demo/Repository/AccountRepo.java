package com.example.demo.Repository;

import com.example.demo.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AccountRepo extends JpaRepository<Account, Long> {
     List<Account> findByAdminTrue();

}
