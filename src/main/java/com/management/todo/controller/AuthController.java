package com.management.todo.controller;

import com.management.todo.dto.LoginDTO;
import com.management.todo.dto.RegisterDTO;
import com.management.todo.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    //Register REST API
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO){
        String register = authService.register(registerDTO);
        return new ResponseEntity<>(register, HttpStatus.CREATED);
    }

    //Login REST API
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO){
        String response = authService.login(loginDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
