package com.example.eshop.products;

import com.example.eshop.users.User;
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

    @GetMapping("/products")
    String getProducts(Model model) {
        model.addAttribute("products", productService.getProducts());
        model.addAttribute("productcategories", ProductCategory.values());
        return "productpage";
    }

    @GetMapping("/product/create")
    String getCreateProduct(Model model) {
        model.addAttribute("productcategories", ProductCategory.values());
        return "createproduct";
    }

    @PostMapping("/product/create")
    String addProduct(Model model,
                      @RequestParam ProductCategory productCategory,
                      @RequestParam String productname,
                      @RequestParam int productprice) {
        Product product = new Product(productname, productprice, productCategory);

        productService.addProduct(product);

        model.addAttribute("productcreatesucces", true);
        model.addAttribute("productname", productname);
        model.addAttribute("productcategories", ProductCategory.values());

        return "createproduct";
    }

    @GetMapping("/products/category")
    String getProductByCategory(Model model,
                                @RequestParam ProductCategory productCategory) {
        model.addAttribute("productcategories", ProductCategory.values());
        model.addAttribute("products", productService.getProductsByCategory(productCategory));
        return "productpage";
    }

    @GetMapping("/product/search")
    String getProductByName(Model model,
                            @RequestParam String name) {
        model.addAttribute("productcategories", ProductCategory.values());
        model.addAttribute("products", productService.getProductsByName(name));
        return "productpage";
    }
}
