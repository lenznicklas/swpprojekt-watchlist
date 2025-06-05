package com.example.controllers;

import com.example.dto.*;
import com.example.models.User;
import com.example.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("http://localhost:8081")
public class AuthController {

    private final UserRepository userRepo;
    public AuthController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping("/register")
    public LoginResponseDto register(@RequestBody UserRegistrationDto dto) {
        if (userRepo.findByUsername(dto.getUsername()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exists");
        }
        User u = new User(dto.getUsername(), dto.getPassword());
        userRepo.save(u);
        return new LoginResponseDto(u.getId(), u.getUsername());
    }

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto dto) {
        User u = userRepo.findByUsername(dto.getUsername())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED));
        if (!u.getPassword().equals(dto.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        return new LoginResponseDto(u.getId(), u.getUsername());
    }
}
