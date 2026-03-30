package com.auction.controller;

import com.auction.service.AuctionService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuctionController {

    private final AuctionService service;

    public AuctionController(AuctionService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) return "redirect:/login";

        model.addAttribute("items", service.getAllItems());
        model.addAttribute("user", session.getAttribute("user"));
        return "index";
    }

    @PostMapping("/bid")
    public String bid(Long id, String name, double amount) {
        service.placeBid(id, name, amount);
        return "redirect:/";
    }

    @GetMapping("/admin")
    public String admin() { return "admin"; }

    @PostMapping("/add-item")
    public String add(String name, String description, double price) {
        service.addItem(name, description, price);
        return "redirect:/";
    }
}