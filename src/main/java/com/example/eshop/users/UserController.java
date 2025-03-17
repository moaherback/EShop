package com.example.eshop.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user/create")
    String getCreate(Model model) {

        return "usercreatepage";
    }

    @PostMapping("/user/create")
    String addUser(Model model,
                   @RequestParam String username,
                   @RequestParam String password){
        System.out.println(username);
        System.out.println(password);
        return "usercreatepage";
    }

}
