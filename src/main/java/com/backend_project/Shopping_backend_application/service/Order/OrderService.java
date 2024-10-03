package com.backend_project.Shopping_backend_application.service.Order;

import com.backend_project.Shopping_backend_application.enums.OrderStatus;
import com.backend_project.Shopping_backend_application.exceptions.ResourceNotFoundException;
import com.backend_project.Shopping_backend_application.model.Cart;
import com.backend_project.Shopping_backend_application.model.Order;
import com.backend_project.Shopping_backend_application.model.OrderItem;
import com.backend_project.Shopping_backend_application.model.Product;
import com.backend_project.Shopping_backend_application.repository.OrderRepository;
import com.backend_project.Shopping_backend_application.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService{

    private final OrderRepository orderRepository;

    private ProductRepository productRepository;

    @Override
    public Order placeOrder(Long userId) {
        return null;
    }

    private Order createOrder(Cart cart) {
        Order order = new Order();
        order.setOrderStatus(OrderStatus.PENDING);
        order.setOrderDate(LocalDate.now());
        return order;
    }

    private List<OrderItem>createOrderItem(Order order, Cart cart) {

        return cart.getCartItems().stream().map(cartItem -> {
            Product product = cartItem.getProduct();
            product.setInventory(product.getInventory() - cartItem.getQuantity());
            productRepository.save(product);
            return  new OrderItem(order,product,cartItem.getQuantity(),cartItem.getUnitPrice());
        }).toList();
    }

    private BigDecimal calculateTotalAmount(List<OrderItem> orderItem) {

        return orderItem.stream().map(item -> item.getPrice().multiply(new BigDecimal(item.getQuantity())))
                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    @Override
    public Order getOrder(Long orderId) {

        return orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not Found"));

    }
}
