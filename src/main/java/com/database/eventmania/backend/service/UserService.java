package com.database.eventmania.backend.service;

import com.database.eventmania.backend.entity.User;
import com.database.eventmania.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long userId) throws SQLException {
        return userRepository.getUserById(userId);
    }
}