package com.rentmangementsystem.user.service;

import com.rentmangementsystem.user.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByUsername(String username);

    void addUser(User user);


}
