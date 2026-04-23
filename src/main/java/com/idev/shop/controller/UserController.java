package com.idev.shop.controller;

import com.idev.shop.dto.UserDTO;
import com.idev.shop.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "User Profile", description = "Các API liên quan đến người dùng và tài khoản")
public class UserController {

    private final UserService userService;

    @GetMapping
    @Operation(summary = "Lấy danh sách tất cả người dùng", description = "Trả về danh sách các tài khoản trong hệ thống")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
