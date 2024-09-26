package com.backend_project.Shopping_backend_application.repository;

import com.backend_project.Shopping_backend_application.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    void deleteAllByCartId(Long id);
}
