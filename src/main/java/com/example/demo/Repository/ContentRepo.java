package com.example.demo.Repository;

import com.example.demo.Entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface ContentRepo extends JpaRepository<Content, Long> {
}
