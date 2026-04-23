package com.idev.shop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@Tag(name = "Admin Module", description = "Các API dành riêng cho quản trị viên")
public class AdminController {

    @GetMapping("/products")
    @Operation(summary = "Admin - Danh sách sản phẩm")
    public ResponseEntity<String> adminGetProducts() {
        return ResponseEntity.ok("Admin lấy danh sách SP");
    }

    @PostMapping("/products")
    @Operation(summary = "Admin - Tạo sản phẩm mới")
    public ResponseEntity<String> adminCreateProduct() {
        return ResponseEntity.ok("Admin tạo SP mới");
    }

    @PutMapping("/products/{id}")
    @Operation(summary = "Admin - Cập nhật sản phẩm")
    public ResponseEntity<String> adminUpdateProduct(@PathVariable Long id) {
        return ResponseEntity.ok("Admin cập nhật SP " + id);
    }

    @DeleteMapping("/products/{id}")
    @Operation(summary = "Admin - Xóa sản phẩm")
    public ResponseEntity<String> adminDeleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok("Admin xóa SP " + id);
    }

    @PostMapping("/categories")
    @Operation(summary = "Admin - Tạo danh mục mới")
    public ResponseEntity<String> adminCreateCategory() {
        return ResponseEntity.ok("Admin tạo danh mục");
    }

    @GetMapping("/orders")
    @Operation(summary = "Admin - Danh sách đơn hàng toàn hệ thống")
    public ResponseEntity<String> adminGetOrders() {
        return ResponseEntity.ok("Admin lấy danh sách Đơn hàng");
    }

    @PatchMapping("/orders/{id}/status")
    @Operation(summary = "Admin - Cập nhật trạng thái đơn hàng")
    public ResponseEntity<String> adminUpdateOrderStatus(@PathVariable Long id) {
        return ResponseEntity.ok("Admin cập nhật trạng thái đơn " + id);
    }
}
