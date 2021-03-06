package com.codecool.hp_backend.controller;

import com.codecool.hp_backend.entity.HPUser;
import com.codecool.hp_backend.security.JwtTokenServices;
import com.codecool.hp_backend.service.DataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.stream.Collectors;


@RestController
@CrossOrigin
public class AuthController {

    private final DataHandler dataHandler;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenServices jwtTokenServices;

    @Autowired
    public AuthController(@Qualifier("dataHandlerDB") DataHandler dataHandler,
                          AuthenticationManager authenticationManager,
                          JwtTokenServices jwtTokenServices) {
        this.dataHandler = dataHandler;
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        this.authenticationManager = authenticationManager;
        this.jwtTokenServices = jwtTokenServices;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody HPUser hpUser) {
        System.out.println(hpUser);
        System.out.println("username: " + hpUser.getUsername() + "; password: " + hpUser.getPassword());
        Map<Object, Object> model = new HashMap<>();
        if(dataHandler.checkIfUsernameExists(hpUser.getUsername())){
            model.put("status", "Username already in use!");
            return ResponseEntity.ok(model);
        }else if(dataHandler.checkIfEmailExists(hpUser.getEmail())){
            model.put("status", "Email already in use!");
            return ResponseEntity.ok(model);
        }
        hpUser.setPassword(passwordEncoder.encode(hpUser.getPassword()));
        dataHandler.saveUser(hpUser);
        model.put("status", "Registration successful!");
        return ResponseEntity.ok(model);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody HPUser hpUser, HttpServletResponse response) {
        Map<Object, Object> model = new HashMap<>();
        try {
            System.out.println("username: " + hpUser.getUsername() + "; password: " + hpUser.getPassword());
            String userName = hpUser.getUsername();
            String password = hpUser.getPassword();
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
            List<String> roles = authentication.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            String token = jwtTokenServices.createToken(userName, roles);
            System.out.println(token);

            model.put("status", "Login successful!");
            model.put("username", userName);
            model.put("roles", roles);
            model.put("token", token);

            return ResponseEntity.ok(model);

        } catch (AuthenticationException e) {
            model.put("status", "Invalid username or password!");
            return ResponseEntity.ok(model);
        }
    }

}
