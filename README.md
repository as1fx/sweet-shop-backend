
# Sweet Shop Management System

A basis backend system for managing a sweet shop with JWT based authentication, built with Spring Boot and MySQL.


## Features

- **JWT Authentication** - Secure login/register with token-based auth
- **Sweeet Managemnt** - CRUD operations for sweet inventory
- **Spring Security** - Secure endpoints with proper authorization
- **Maven** - Dependency management and build tool


## Tech Stack

- **Java 17+**
- **Spring Boot 4.0.0**
- **Spring Security**
- **Spring Data JPA**
- **MySQL**
- **JJWT**
- **Lombok**
- **Maven**


## Project Structure
```
sweet-shop-backend/
├── src/main/java/com/asif/sweet_shop_backend/
│   ├── Controller/          # REST API endpoints
│   │   ├── AuthController.java
│   │   └── SweetController.java
│   ├── Entity/              # JPA entities
│   │   ├── User.java
│   │   └── Sweet.java
│   ├── Repository/          # Data access layer
│   │   ├── UserRepository.java
│   │   └── SweetRepository.java
│   ├── Service/             # Business logic
│   │   ├── AuthService.java
│   │   └── SweetService.java
│   ├── Security/            # Security configuration
│   │   ├── JwtUtil.java
|   |   ├── JwtFilter.java
|   └── SecurityConfig.java
│   └── SweetShopBackendApplication.java
├── src/main/resources/
│   ├── application.properties
└── pom.xml
```
## Installation

### Prerequisites
- Java 17+ or higher
- Spring Boot 4.0.0
- MySQL
---

## Steps to Run
### Clone the repository

```bash

git clone https://github.com/as1fx/sweet-shop-backend.git
cd sweet-shop-backend

```
---

### Build the project

```bash
mvn clean install
```

---
### Run the application

```bash
mvn spring-boot:run
```

---

### Access the application

- API Base URL: `http://localhost:8080`
## Authentication Flow
### Register a new user

```http
POST /api/auth/register
Content-Type: application/json

{
    "email": "user@example.com",
    "password": "password123"
}
```

### Login to get JWT token

```http
POST /api/auth/login
Content-Type: application/json

{
    "email": "user@example.com",
    "password": "password123"
}
```
### Response

```json
{
    "Token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

### Use the token in protected endpoints
Add to headers:

```text
Authorization: Bearer <your-token>
```
## API Endpoints
### Authentication

```
Method	    Endpoint	            Description	                Auth Required
POST	    /api/auth/register	    Register new user           No
POST	    /api/auth/login	    Login and get JWT token	No
```

### Sweets Management

```
Method	    Endpoint	        Description	    Auth Required
GET	    /api/sweets	        Get all sweets      Yes
GET	    /api/sweets/{id}	Get sweet by ID	    Yes
POST	    /api/sweets	        Create new sweet    Yes 
PUT	    /api/sweets/{id}	Update sweet	    Yes 
DELETE	    /api/sweets/{id}	Delete sweet	    Yes 
```
## Sweet Entity Model

```java
{
    "id": 1,
    "name": "Gulab Jamun",
    "category": "Indian",
    "price": 25.50,
    "quantity": 100
}
```
## Database Configuration
### Sample Data (data.sql)

```sql
INSERT INTO sweet (name, category, price, quantity) VALUES
('Gulab Jamun', 'Indian', 25.50, 100),
('Rasgulla', 'Indian', 20.00, 150),
('Kaju Katli', 'Indian', 50.00, 75),
('Chocolate Truffle', 'International', 15.00, 200);
```
## Application Properties

```properties
# Server Configuration
server.port=8080

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/sweet_shop
spring.datasource.username=<your_username>
spring.datasource.password=<your_password>

# JPA Settings
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
## Authors

#### `Asif Reja Mondal`

