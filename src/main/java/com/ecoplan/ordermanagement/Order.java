package com.ecoplan.ordermanagement;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
@Entity
@Table(name = "orders")
    public class Order {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        @NotBlank(message = "Product name cannot be empty")
        private String productName;
        @Min(value = 1, message = "Quantity must be at least 1")
        private int quantity;
        @DecimalMin(value = "0.01", message = "Price must be greater than zero")
        private double price;
        public Order(){

        }
        // Constructor
        public Order(Integer id, String productName, int quantity, double price) {
            this.id = id;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        // Getters
        public Integer getId() {
            return id;
        }

        public String getProductName() {
            return productName;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getPrice() {
            return price;
        }

        // Calculate total price
        public double getTotalPrice() {
            return quantity * price;
        }
        public void setId(Integer id) {
            this.id = id;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }




