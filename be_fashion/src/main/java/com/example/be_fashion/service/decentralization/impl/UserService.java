package com.example.be_fashion.service.decentralization.impl;


import com.example.be_fashion.model.decentralization.User;
import com.example.be_fashion.repository.decentralization.IUserRepository;
import com.example.be_fashion.service.decentralization.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public String existsByUserName(String username) {
        return userRepository.existsByUserName(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String name) {
        return userRepository.findByUsername(name);
    }


    @Override
    public void updatePassword(User user, String newPassword) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);
        userRepository.saveNewPassword(encodedPassword,user.getUsername());
    }

    @Override
    public void saveCreateGmail(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> showUsername(String username) {
        return userRepository.showUsername(username);
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public void updateUser(User user, String username) {
        userRepository.saveUser(user, username);
    }
}