package com.ecommerce.shopzone.controller;

import com.ecommerce.shopzone.entity.User;
import com.ecommerce.shopzone.service.OrderService;
import com.ecommerce.shopzone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.security.Principal;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String myOrders(Principal principal, Model model) {
        User user = userService.findByUsername(principal.getName()).orElseThrow();
        model.addAttribute("orders", orderService.getUserOrders(user));
        return "orders";
    }

    @GetMapping("/{id}")
    public String orderDetail(@PathVariable Long id, Model model) {
        orderService.getOrderById(id).ifPresent(order -> model.addAttribute("order", order));
        return "order-detail";
    }

    @GetMapping("/checkout")
    public String checkout(Principal principal, Model model) {
        User user = userService.findByUsername(principal.getName()).orElseThrow();
        model.addAttribute("user", user);
        return "checkout";
    }

    @PostMapping("/place")
    public String placeOrder(@RequestParam String shippingAddress,
                            Principal principal, RedirectAttributes redirectAttributes) {
        try {
            User user = userService.findByUsername(principal.getName()).orElseThrow();
            orderService.createOrder(user, shippingAddress);
            redirectAttributes.addFlashAttribute("success", "Order placed successfully!");
            return "redirect:/orders";
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/cart";
        }
    }
}
