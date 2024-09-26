package com.backend_project.Shopping_backend_application.service.cart;

import com.backend_project.Shopping_backend_application.model.CartItem;

public interface ICartItemService {

    void addItemToCart(Long cartId, Long productId, int quantity);

    void removeItemFromCart(Long cartId, Long productId);

    void updateItemQuantity(Long cartId, Long productId, int quantity);


    CartItem getCartItem(Long cartId, Long productId);
}
