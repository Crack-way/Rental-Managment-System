package com.rentmangementsystem.auth.service;

import com.rentmangementsystem.auth.dto.RegisterRequest;
import com.rentmangementsystem.auth.dto.AuthenticationRequest;
import com.rentmangementsystem.auth.dto.AuthenticationResponse;
import com.rentmangementsystem.jwt.service.JwtService;
import com.rentmangementsystem.role.Role;
import com.rentmangementsystem.user.entity.User;
import com.rentmangementsystem.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {


    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {

        var user = User.builder()
                .username(request.getUsername()).
                password(passwordEncoder.encode(request.getPassword())).role(Role.USER)
                .build();
        userService.addUser(user);

       

        return AuthenticationResponse.builder().token("register")
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {


        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user=userService.findByUsername(request.getUsername()).orElseThrow();
        var jwToken = jwtService.generateToken(user);


        return AuthenticationResponse.builder().token(jwToken)
                .build();
    }


}
