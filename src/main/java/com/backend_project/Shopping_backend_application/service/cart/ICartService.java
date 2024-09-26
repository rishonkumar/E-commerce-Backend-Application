package com.backend_project.Shopping_backend_application.service.cart;

import com.backend_project.Shopping_backend_application.model.Cart;

import java.math.BigDecimal;

public interface ICartService {
    Cart getCart(Long id);

    void clearCart(Long id);

    BigDecimal getTotalPrice(Long id);


}
