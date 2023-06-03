package com.example.demo.Repository;

import com.example.demo.Entity.AccountConversationBroker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface AccountConversationBrokerRepo extends JpaRepository<AccountConversationBroker,Long> {
//    @Query("SELECT * FROM AccountConversationBroker ac INNER JOIN Account a")
//    AccountConversationBroker getContentByAccountNickName();
}
