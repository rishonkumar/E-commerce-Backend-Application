package com.backend_project.Shopping_backend_application.service.Order;

import com.backend_project.Shopping_backend_application.model.Order;

public interface IOrderService {

    Order placeOrder(Long userId);

    Order getOrder(Long orderId);
}
