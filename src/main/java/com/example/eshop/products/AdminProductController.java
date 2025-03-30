package com.example.eshop.products;

import com.example.eshop.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminProductController {
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;

    @GetMapping("/product/create")
    String getCreateProduct(Model model) {
        if (userService.getLoggedInUser()== null || userService.getLoggedInUser().getRole()!=1){
            return "redirect:/admin/login";
        }
        model.addAttribute("productcategories", ProductCategory.values());
        return "createproduct";
    }

    @PostMapping("/product/create")
    String addProduct(Model model,
                      @RequestParam ProductCategory productCategory,
                      @RequestParam String productname,
                      @RequestParam int productprice) {
        if (userService.getLoggedInUser()== null || userService.getLoggedInUser().getRole()!=1){
            return "redirect:/admin/login";
        }
        Product product = new Product(productname, productprice, productCategory);

        productService.addProduct(product);

        model.addAttribute("productcreatesucces", true);
        model.addAttribute("productname", productname);
        model.addAttribute("productcategories", ProductCategory.values());

        return "createproduct";
    }
}
