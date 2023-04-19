package com.example.demo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
public class AccountDto {
    private Long user_ID;
    private String accountName;
    private String accountPassword;
    private String userName;
    private Date userBorn;
    private String accountNote;
    private String accountNickName;
    private boolean admin;

}
