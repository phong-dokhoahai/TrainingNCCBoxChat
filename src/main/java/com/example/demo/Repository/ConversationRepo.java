package com.example.demo.Repository;

import com.example.demo.Entity.Account;
import com.example.demo.Entity.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversationRepo extends JpaRepository<Conversation, Long> {

}
