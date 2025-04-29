package com.example.eshop.users;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminUserController {
    @Autowired UserService userService;

    @GetMapping("/admin/login")
    String getAdminLogin(Model model){
        return "adminloginpage";
    }

    @PostMapping("/admin/login")
    String adminLogin(Model model,
                      @RequestParam String username,
                      @RequestParam String password) {
        User user = userService.login(username, password);

        if (user == null || user.getRole() != 1 ) {
            model.addAttribute("loginfailed", true);
        } else {
           return "redirect:/admin/orders";
        }
        return "adminloginpage";
    }
}
