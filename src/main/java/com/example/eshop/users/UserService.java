package com.example.eshop.users;

import com.example.eshop.products.Product;
import com.example.eshop.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public class UserService {
    @Autowired
    UserRepository userRepository;


    void add(User user) {
        userRepository.save(user);

    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
