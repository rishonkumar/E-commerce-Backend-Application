package com.backend_project.Shopping_backend_application.repository;

import com.backend_project.Shopping_backend_application.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    void deleteAllByCartId(Long id);
}
