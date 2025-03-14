package com.example.eshop.users;

import org.springframework.stereotype.Service;

@Service


public class UserService {
    UserRepository repository;

    void add (User user) {
        repository.save(user);

    }
}
