package com.rentmangementsystem.user.service;

import com.rentmangementsystem.user.entity.User;
import com.rentmangementsystem.user.exception.UserNotFoundException;
import com.rentmangementsystem.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements  UserService{

    private final UserRepo userRepo;


    public Optional<User> findByUsername(String username){

       if(userRepo.findByUsername(username)!=null){

           return userRepo.findByUsername(username);
       }

       else throw new UserNotFoundException("User not found");

    }


    public void addUser(User user){

        userRepo.save(user);


    }



}
