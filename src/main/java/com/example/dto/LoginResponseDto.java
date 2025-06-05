package com.example.dto;

public class LoginResponseDto {
    private Long userId;
    private String username;
    public LoginResponseDto(Long id, String name) {
        this.userId = id; this.username = name;
    }
    public Long getUserId() { return userId; }
    public String getUsername() { return username; }
}
