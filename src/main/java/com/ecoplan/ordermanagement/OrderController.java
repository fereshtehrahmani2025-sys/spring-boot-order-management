package com.ecoplan.ordermanagement;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
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
    public Order createOrder(@RequestBody Order order) {

        return orderService.createOrder(order);
    }
    @DeleteMapping("/orders/{id}")
    public String deleteOrder(@PathVariable int id) {

        if (orderService.deleteOrder(id)) {
            return "Order deleted successfully!";
        }

        return "Order not found!";
    }
    @PutMapping("/orders/{id}")
    public String updateOrder(
            @PathVariable int id,
            @RequestBody Order updatedOrder) {

        if (orderService.updateOrder(id, updatedOrder)) {
            return "Order updated successfully!";
        }

        return "Order not found!";
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
