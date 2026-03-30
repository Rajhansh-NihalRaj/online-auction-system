package com.auction.service;

import com.auction.model.User;
import com.auction.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public String register(User user) {
        if (repo.findByUsername(user.getUsername()) != null) {
            return "User exists!";
        }
        repo.save(user);
        return "Success";
    }

    public User login(String u, String p) {
        User user = repo.findByUsername(u);
        return (user != null && user.getPassword().equals(p)) ? user : null;
    }
}