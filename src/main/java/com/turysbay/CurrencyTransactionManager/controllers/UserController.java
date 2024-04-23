package com.turysbay.CurrencyTransactionManager.controllers;

import com.turysbay.CurrencyTransactionManager.entity.User;
import com.turysbay.CurrencyTransactionManager.services.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserServiceImpl userService;
    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody User userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());

        userService.createUser(user);
        return ResponseEntity.ok().build();
    }

}
