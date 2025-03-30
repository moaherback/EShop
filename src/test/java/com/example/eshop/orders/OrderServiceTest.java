package com.example.eshop.orders;

import com.example.eshop.basket.BasketService;
import com.example.eshop.basket.BasketView;
import com.example.eshop.users.User;
import com.example.eshop.users.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private BasketService basketService;

    @Mock
    private UserService userService;

    @Mock
    private OrderRepository orderRepository;

    private User mockUser;
    private BasketView mockBasket;

    @BeforeEach
    void setup() {
        mockUser = new User();
        mockUser.setUserId(123);
        mockUser.setUsername("testuser");

        BasketView.BasketProductView product = new BasketView.BasketProductView(1, "Coffee", 50, 2);
        mockBasket = new BasketView(List.of(product));
    }

    @Test
    void testCreateOrder() {
        when(userService.getLoggedInUser()).thenReturn(mockUser);
        when(basketService.showBasket()).thenReturn(mockBasket);

        Order order = orderService.createOrder();

        assertEquals(mockUser.getUserId(), order.getUserId());
        assertEquals(mockUser.getUsername(), order.getUsername());
        assertEquals(1, order.getOrderLines().size());
        assertEquals(100, order.getOrderTotal()); // 2 * 50

        verify(orderRepository).save(any(Order.class));
    }

    @Test
    void testDispatchOrder() {
        Order mockOrder = new Order();
        mockOrder.setOrderId(1);
        mockOrder.setDispatched(false);

        when(orderRepository.findById(1L)).thenReturn(Optional.of(mockOrder));

        orderService.dispatchOrder(1);

        assertTrue(mockOrder.isDispatched());
        verify(orderRepository).save(mockOrder);
    }

    @Test
    void testDispatchOrder_NotFound() {
        when(orderRepository.findById(999L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            orderService.dispatchOrder(999);
        });

        assertEquals("Order not found", exception.getMessage());
    }
}