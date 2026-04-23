package com.idev.shop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Authentication", description = "Các API liên quan đến xác thực người dùng")
public class AuthController {

    @PostMapping("/register")
    @Operation(summary = "Đăng ký tài khoản mới")
    public ResponseEntity<String> register() {
        return ResponseEntity.ok("Đăng ký thành công (Mock)");
    }

    @PostMapping("/login")
    @Operation(summary = "Đăng nhập hệ thống")
    public ResponseEntity<String> login() {
        return ResponseEntity.ok("token-gia-lap-123456");
    }

    @PostMapping("/logout")
    @Operation(summary = "Đăng xuất tài khoản")
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok("Đã đăng xuất");
    }
}
