# 🛒 ShopZone - Full-Stack E-Commerce Application

A complete Full-Stack E-Commerce Application built with **Spring Boot**, **Thymeleaf**, **Spring Security**, and **H2 Database**.

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-green)
![License](https://img.shields.io/badge/License-MIT-blue)

## 🚀 Features

### Customer Features
- 🔐 User Registration & Authentication
- 🛍️ Browse Products with Search & Category Filters
- 🛒 Shopping Cart (Add, Update, Remove items)
- 📦 Order Placement & Order History
- 💳 Checkout with Multiple Payment Options
- 📱 Responsive Design (Bootstrap 5)

### Admin Features
- 📊 Admin Dashboard with Statistics
- ➕ Add / Edit / Delete Products
- 📋 View & Manage All Orders
- 🔄 Update Order Status (Pending → Confirmed → Shipped → Delivered)

## 🛠️ Tech Stack

| Technology | Purpose |
|-----------|---------|
| **Spring Boot 3.2** | Backend Framework |
| **Spring Security** | Authentication & Authorization |
| **Spring Data JPA** | Database ORM |
| **Thymeleaf** | Server-Side Template Engine |
| **H2 Database** | In-Memory Database |
| **Bootstrap 5** | Frontend UI Framework |
| **Bootstrap Icons** | Icon Library |
| **Maven** | Build Tool |

## 📁 Project Structure

```
shopzone/
├── src/main/java/com/ecommerce/shopzone/
│   ├── ShopZoneApplication.java
│   ├── config/
│   │   └── DataLoader.java
│   ├── controller/
│   │   ├── HomeController.java
│   │   ├── ProductController.java
│   │   ├── CartController.java
│   │   ├── OrderController.java
│   │   └── AdminController.java
│   ├── entity/
│   │   ├── User.java
│   │   ├── Product.java
│   │   ├── CartItem.java
│   │   ├── Order.java
│   │   └── OrderItem.java
│   ├── repository/
│   │   ├── UserRepository.java
│   │   ├── ProductRepository.java
│   │   ├── CartItemRepository.java
│   │   └── OrderRepository.java
│   ├── security/
│   │   ├── SecurityConfig.java
│   │   └── CustomUserDetailsService.java
│   └── service/
│       ├── UserService.java
│       ├── ProductService.java
│       ├── CartService.java
│       └── OrderService.java
├── src/main/resources/
│   ├── application.properties
│   └── templates/
│       ├── fragments/layout.html
│       ├── home.html
│       ├── login.html
│       ├── register.html
│       ├── products.html
│       ├── product-detail.html
│       ├── cart.html
│       ├── checkout.html
│       ├── orders.html
│       ├── order-detail.html
│       └── admin/
│           ├── dashboard.html
│           └── product-form.html
└── pom.xml
```

## ⚡ Quick Start

### Prerequisites
- Java 17+
- Maven 3.6+

### Run the Application

```bash
# Clone the repository
git clone https://github.com/Komatlakarthik/ecommerce-springboot.git
cd ecommerce-springboot

# Run with Maven
./mvnw spring-boot:run
```

The application will start at **http://localhost:8080**

### Default Credentials

| Role | Username | Password |
|------|----------|----------|
| Admin | admin | admin123 |

Register as a new customer through the registration page.

## 📸 Screenshots

### Home Page
- Hero section with call-to-action
- Featured products grid
- Feature highlights (Free Shipping, Secure Payment, Easy Returns)

### Product Catalog
- Grid layout with product cards
- Search functionality
- Category filters
- Stock availability indicators

### Shopping Cart
- Product details with images
- Quantity management
- Order summary with total

### Admin Dashboard
- Product management (CRUD)
- Order management with status updates
- Statistics overview

## 🗄️ Database

Uses **H2 In-Memory Database** for easy setup. Access the H2 Console at:
- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:shopzonedb`
- Username: `sa`
- Password: *(empty)*

## 📝 Sample Data

The application comes pre-loaded with:
- 1 Admin user
- 12 Sample products across categories:
  - Electronics (iPhone, Samsung, MacBook, Sony Headphones, Kindle, Canon Camera)
  - Footwear (Nike, Adidas)
  - Clothing (Levi's Jeans, North Face Jacket)
  - Home & Kitchen (Instant Pot, Dyson Vacuum)

## 📄 License

This project is licensed under the MIT License.

## 👤 Author

**Karthik Reddy Komatla**
- GitHub: [@Komatlakarthik](https://github.com/Komatlakarthik)
- LinkedIn: [Karthik Reddy Komatla](https://www.linkedin.com/in/karthik-reddy-komatla-2627b530b/)
