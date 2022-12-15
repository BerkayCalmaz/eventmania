package com.database.eventmania.backend.service;

import com.database.eventmania.backend.entity.BasicUser;
import com.database.eventmania.backend.entity.enums.Gender;
import com.database.eventmania.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDate;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public BasicUser getUserById(Long userId) throws SQLException {
        return userRepository.getUserById(userId);
    }

    public BasicUser getUserByEmailAndPassword(String email, String password) throws SQLException {
        return userRepository.getUserByEmailAndPassword(email, password);
    }

    public boolean saveUser(String email, String password,
                            String firstName, String lastName, Gender gender,
                            String phoneNumber, LocalDate dob) throws SQLException {
        String hashedPassword = bCryptPasswordEncoder.encode(password);
        return userRepository.saveUser(email, hashedPassword, firstName, lastName, gender, phoneNumber, dob);
    }
}
