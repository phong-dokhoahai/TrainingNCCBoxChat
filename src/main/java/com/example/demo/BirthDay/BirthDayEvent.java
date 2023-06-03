package com.example.demo.BirthDay;

import org.springframework.context.ApplicationEvent;

/*
DoorBellEvent phải kế thừa lớp ApplicationEvent của Spring
Như vậy nó mới được coi là một sự kiện hợp lệ.
 */
public class BirthDayEvent extends ApplicationEvent {
//    private String username;
//    public BirthDayEvent(Object source, String username) {
//        super(source);
//        this.username=username;
//    }
//
//    public String getUsername() {
//        return username;
//    }
    private long id;
    public BirthDayEvent(Object source, long id) {
        super(source);
        this.id=id;
    }

    public long getId() {
        return id;
    }
}
