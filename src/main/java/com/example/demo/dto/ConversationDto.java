package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class ConversationDto {
    private Long conversation_ID;
    private String conversationName;
    private Integer numPeople;

}
