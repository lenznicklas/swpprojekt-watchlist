package com.example.dto;

public class LoginRequestDto {
    private String username;
    private String password;
    public LoginRequestDto() {}
    public String getUsername() { return username; }
    public void setUsername(String u) { this.username = u; }
    public String getPassword() { return password; }
    public void setPassword(String p) { this.password = p; }
}