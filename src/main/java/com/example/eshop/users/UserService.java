package com.example.eshop.users;

import com.example.eshop.products.Product;
import com.example.eshop.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;
@SessionScope
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Service


public class UserService {
    @Autowired
    UserRepository userRepository;

    public User getLoggedInUser() {
        return loggedInUser;
    }

    private User loggedInUser = null;

    void add(User user) {
        userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(String username, String password) {
        return userRepository.getUserByUsernameAndPassword(username, password);
    }

    public User login(String username, String password) {
        User user = getUser(username, password);
        if (user != null) {
            loggedInUser = user;
        }
        return user;
    }

}
