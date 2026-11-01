package com.ecommerce.shopzone.config;

import com.ecommerce.shopzone.entity.Product;
import com.ecommerce.shopzone.entity.User;
import com.ecommerce.shopzone.repository.ProductRepository;
import com.ecommerce.shopzone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) {
        // Create admin user
        if (!userService.existsByUsername("admin")) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setEmail("admin@shopzone.com");
            admin.setPassword("admin123");
            admin.setFullName("Admin User");
            admin.setRole(User.Role.ADMIN);
            userService.registerUser(admin);
        }

        // Create sample products
        if (productRepository.count() == 0) {
            createProduct("iPhone 15 Pro", "Latest Apple smartphone with A17 Pro chip, titanium design, and 48MP camera system.", 999.99, 50, "Electronics", "https://images.unsplash.com/photo-1695048133142-1a20484d2569?w=400");
            createProduct("Samsung Galaxy S24 Ultra", "Premium Android smartphone with S Pen, 200MP camera, and AI features.", 1199.99, 40, "Electronics", "https://images.unsplash.com/photo-1610945415295-d9bbf067e59c?w=400");
            createProduct("MacBook Air M3", "Ultra-thin laptop with M3 chip, 15-hour battery life, and Liquid Retina display.", 1299.99, 30, "Electronics", "https://images.unsplash.com/photo-1517336714731-489689fd1ca8?w=400");
            createProduct("Sony WH-1000XM5", "Premium noise-cancelling wireless headphones with 30-hour battery.", 349.99, 100, "Electronics", "https://images.unsplash.com/photo-1618366712010-f4ae9c647dcb?w=400");
            createProduct("Nike Air Max 270", "Comfortable lifestyle shoe with Max Air unit for all-day wear.", 150.00, 200, "Footwear", "https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=400");
            createProduct("Adidas Ultraboost 23", "Performance running shoe with BOOST midsole technology.", 190.00, 150, "Footwear", "https://images.unsplash.com/photo-1608231387042-66d1773070a5?w=400");
            createProduct("Levi's 501 Original Jeans", "Classic straight-fit jeans with authentic denim craftsmanship.", 69.50, 300, "Clothing", "https://images.unsplash.com/photo-1542272454315-4c01d7abdf4a?w=400");
            createProduct("The North Face Puffer Jacket", "Insulated winter jacket with water-repellent finish.", 250.00, 80, "Clothing", "https://images.unsplash.com/photo-1544923246-77307dd270b5?w=400");
            createProduct("Kindle Paperwhite", "Waterproof e-reader with 6.8-inch display and adjustable warm light.", 139.99, 120, "Electronics", "https://images.unsplash.com/photo-1594377157609-5c996118ac7f?w=400");
            createProduct("Instant Pot Duo 7-in-1", "Multi-functional pressure cooker, slow cooker, rice cooker, and more.", 89.95, 200, "Home & Kitchen", "https://images.unsplash.com/photo-1585515320310-259814833e62?w=400");
            createProduct("Dyson V15 Detect", "Advanced cordless vacuum with laser dust detection technology.", 749.99, 60, "Home & Kitchen", "https://images.unsplash.com/photo-1558317374-067fb5f30001?w=400");
            createProduct("Canon EOS R6 Mark II", "Full-frame mirrorless camera with 24.2MP sensor and 4K video.", 2499.00, 25, "Electronics", "https://images.unsplash.com/photo-1516035069371-29a1b244cc32?w=400");
        }
    }

    private void createProduct(String name, String description, double price, int stock, String category, String imageUrl) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setStock(stock);
        product.setCategory(category);
        product.setImageUrl(imageUrl);
        productRepository.save(product);
    }
}
