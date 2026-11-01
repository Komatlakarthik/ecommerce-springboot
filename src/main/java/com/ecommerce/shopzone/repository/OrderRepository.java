package com.ecommerce.shopzone.repository;

import com.ecommerce.shopzone.entity.Order;
import com.ecommerce.shopzone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserOrderByOrderDateDesc(User user);
    List<Order> findAllByOrderByOrderDateDesc();
}
