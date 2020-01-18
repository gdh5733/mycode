package com.alan.demo.service;

import org.springframework.stereotype.Component;

@Component
public interface UserService {
    String selectTeleByid(String id);
}

