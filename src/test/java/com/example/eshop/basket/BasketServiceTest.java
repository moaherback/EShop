package com.example.eshop.basket;

import com.example.eshop.products.Product;
import com.example.eshop.products.ProductCategory;
import com.example.eshop.products.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BasketServiceTest {

    @InjectMocks
    private BasketService basketService;

    @Mock
    private ProductService productService;


    Product mockProduct = new Product();

    @BeforeEach
    void setUp() {
        mockProduct.setProductId(1);
        mockProduct.setProductName("Coffee");
        mockProduct.setProductPrice(100);
        mockProduct.setProductCategory(ProductCategory.COFFEE);
    }

    @Test
    void testAddProduct() {


        Mockito.when(productService.getProductById(List.of(1))).thenReturn(List.of(mockProduct));

        basketService.addProduct(1, 2);
        assertEquals(2, basketService.showBasket().getProducts().get(0).getQuantity());
    }

    @Test
    void testUpdateProductQuantity() {

        Mockito.when(productService.getProductById(List.of(1))).thenReturn(List.of(mockProduct));

        basketService.addProduct(1, 1);
        basketService.updateBasket(1, 3);
        assertEquals(3, basketService.showBasket().getProducts().get(0).getQuantity());
    }

    @Test
    void testRemoveProduct() {

        Mockito.when(productService.getProductById(List.of())).thenReturn(List.of());

        basketService.addProduct(1, 1);
        basketService.removeProduct(1);
        assertTrue(basketService.showBasket().getProducts().isEmpty());
    }

    @Test
    void testShowBasket() {
        basketService.addProduct(1, 2);

        when(productService.getProductById(List.of(1))).thenReturn(List.of(mockProduct));

        BasketView basketView = basketService.showBasket();
        assertEquals(1, basketView.getProducts().size());
        assertEquals("Coffee", basketView.getProducts().get(0).getProductName());
        assertEquals(2, basketView.getProducts().get(0).getQuantity());
    }
}
