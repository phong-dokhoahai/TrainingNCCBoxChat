package com.example.demo.Repository;

import com.example.demo.Entity.RelatedUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ListUserRepo extends JpaRepository<RelatedUser, Long> {
}
