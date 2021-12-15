package com.daolayer.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {
    public boolean isValid(String name) {
        //Выводим в консоль пользователя
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        return name.equals("Alex");
    }
}
