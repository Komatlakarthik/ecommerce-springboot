package com.ecommerce.shopzone.controller;

import com.ecommerce.shopzone.entity.User;
import com.ecommerce.shopzone.service.CartService;
import com.ecommerce.shopzone.service.ProductService;
import com.ecommerce.shopzone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.security.Principal;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String viewCart(Principal principal, Model model) {
        User user = userService.findByUsername(principal.getName()).orElseThrow();
        model.addAttribute("cartItems", cartService.getCartItems(user));
        model.addAttribute("total", cartService.getCartTotal(user));
        return "cart";
    }

    @PostMapping("/add/{productId}")
    public String addToCart(@PathVariable Long productId,
                           @RequestParam(defaultValue = "1") int quantity,
                           Principal principal, RedirectAttributes redirectAttributes) {
        User user = userService.findByUsername(principal.getName()).orElseThrow();
        productService.getProductById(productId).ifPresent(product -> {
            cartService.addToCart(user, product, quantity);
        });
        redirectAttributes.addFlashAttribute("success", "Product added to cart!");
        return "redirect:/cart";
    }

    @PostMapping("/update/{cartItemId}")
    public String updateQuantity(@PathVariable Long cartItemId,
                                 @RequestParam int quantity) {
        if (quantity > 0) {
            cartService.updateQuantity(cartItemId, quantity);
        }
        return "redirect:/cart";
    }

    @PostMapping("/remove/{cartItemId}")
    public String removeFromCart(@PathVariable Long cartItemId) {
        cartService.removeFromCart(cartItemId);
        return "redirect:/cart";
    }
}
