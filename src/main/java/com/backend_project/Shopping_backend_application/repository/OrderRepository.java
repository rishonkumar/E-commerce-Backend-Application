package com.backend_project.Shopping_backend_application.repository;

import com.backend_project.Shopping_backend_application.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
