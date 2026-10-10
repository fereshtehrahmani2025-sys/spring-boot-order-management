package com.ecoplan.ordermanagement;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService=orderService;
    }
    @GetMapping("/")
    public String home() {
        return "Welcome to Order Management System!";
    }
    @GetMapping("/orders")
    public List<Order> getOrders() {
        return orderService.getAllOrders();
    }
    @PostMapping("/orders")
    public Order createOrder(@Valid @RequestBody Order order) {

        return orderService.createOrder(order);
    }
    @DeleteMapping("/orders/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable int id) {

        if (orderService.deleteOrder(id)) {
            return ResponseEntity.ok("Order deleted successfully!") ;
        }

        return ResponseEntity.status(404).body("Order not found!");
    }
    @PutMapping("/orders/{id}")
    public ResponseEntity<String> updateOrder(
            @PathVariable int id,
            @RequestBody Order updatedOrder) {

        if (orderService.updateOrder(id, updatedOrder)) {
            return ResponseEntity.ok("Order updated successfully!");
        }

        return ResponseEntity.status(404).body("Order not found!");
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable int id) {

        Order order = orderService.getOrderById(id);

        if (order == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(order);
    }
}
