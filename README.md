# Spring Boot Order Management System

A RESTful Order Management API built with Java 21, Spring Boot, Spring Data JPA, and PostgreSQL.

## Features
- Create new orders
- Retrieve all orders
- Find orders by ID
- Update existing orders
- Delete orders
- Validate order data using Jakarta Bean Validation
- Return HTTP 400 for invalid input and HTTP 404 for missing orders

## Technologies
- Java 21
- Spring Boot
- Spring Data JPA (Hibernate)
- PostgreSQL
- Maven
- Jakarta Bean Validation
- IntelliJ IDEA
- Git and GitHub

## REST API Endpoints

| Method | Endpoint | Description |
| --- | --- | --- |
| GET | /orders | Get all orders |
| GET | /orders/{id} | Get an order by ID |
| POST | /orders | Create a new order |
| PUT | /orders/{id} | Update an order |
| DELETE | /orders/{id} | Delete an order |

## Example Request

```json
{
  "productName": "Mouse",
  "quantity": 2,
  "price": 25.0
}
```

## Running the Project
1. Install Java 21 and PostgreSQL.
2. Create a PostgreSQL database.
3. Configure the database connection in the Spring Boot application properties.
4. Run `OrderManagementApplication` in IntelliJ IDEA.
5. Test the endpoints using `requests.http`.

The application has been tested locally on port 8081.

## Project Status
Core CRUD and input validation implemented and tested locally.
