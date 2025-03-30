package com.example.eshop.products;

import com.example.eshop.users.User;
import com.example.eshop.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;

    @GetMapping("/products")
    String getProducts(Model model) {
        if (userService.getLoggedInUser()== null){
            return "redirect:/user/login";
        }
        model.addAttribute("products", productService.getProducts());
        model.addAttribute("productcategories", ProductCategory.values());
        return "productpage";
    }

    @GetMapping("/products/category")
    String getProductByCategory(Model model,
                                @RequestParam ProductCategory productCategory) {
        if (userService.getLoggedInUser()== null){
            return "redirect:/user/login";
        }
        model.addAttribute("productcategories", ProductCategory.values());
        model.addAttribute("products", productService.getProductsByCategory(productCategory));
        return "productpage";
    }

    @GetMapping("/product/search")
    String getProductByName(Model model,
                            @RequestParam String name) {
        if (userService.getLoggedInUser()== null){
            return "redirect:/user/login";
        }
        model.addAttribute("productcategories", ProductCategory.values());
        model.addAttribute("products", productService.getProductsByName(name));
        return "productpage";
    }
}
