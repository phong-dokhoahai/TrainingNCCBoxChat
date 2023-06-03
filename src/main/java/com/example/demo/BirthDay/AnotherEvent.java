package com.example.demo.BirthDay;

import org.springframework.context.ApplicationEvent;

public class AnotherEvent extends ApplicationEvent {
    public AnotherEvent(Object source) {
        super(source);
    }
}
