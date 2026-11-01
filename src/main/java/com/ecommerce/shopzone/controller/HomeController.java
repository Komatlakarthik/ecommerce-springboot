package com.ecommerce.shopzone.controller;

import com.ecommerce.shopzone.entity.User;
import com.ecommerce.shopzone.service.ProductService;
import com.ecommerce.shopzone.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", productService.getAllActiveProducts());
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute User user, BindingResult result,
                          RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "register";
        }
        if (userService.existsByUsername(user.getUsername())) {
            result.rejectValue("username", "error.user", "Username already taken");
            return "register";
        }
        if (userService.existsByEmail(user.getEmail())) {
            result.rejectValue("email", "error.user", "Email already registered");
            return "register";
        }
        userService.registerUser(user);
        redirectAttributes.addFlashAttribute("success", "Registration successful! Please login.");
        return "redirect:/login";
    }
}
