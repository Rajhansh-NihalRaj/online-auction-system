package com.auction.service;

import com.auction.model.User;
import com.auction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // ✅ THIS METHOD WAS MISSING (MAIN FIX)
    public void saveUser(User user) {
        userRepository.save(user);
    }
}