package com.idev.shop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
@Tag(name = "Cart", description = "Các API quản lý giỏ hàng")
public class CartController {

    @GetMapping
    @Operation(summary = "Xem giỏ hàng hiện tại")
    public ResponseEntity<String> getCart() {
        return ResponseEntity.ok("Dữ liệu giỏ hàng (Mock)");
    }

    @PostMapping("/items")
    @Operation(summary = "Thêm sản phẩm vào giỏ")
    public ResponseEntity<String> addItem() {
        return ResponseEntity.ok("Món hàng đã được thêm");
    }

    @PutMapping("/items/{id}")
    @Operation(summary = "Cập nhật số lượng sản phẩm trong giỏ")
    public ResponseEntity<String> updateItem(@PathVariable Long id) {
        return ResponseEntity.ok("Đã cập nhật item " + id);
    }

    @DeleteMapping("/items/{id}")
    @Operation(summary = "Xóa sản phẩm khỏi giỏ")
    public ResponseEntity<String> removeItem(@PathVariable Long id) {
        return ResponseEntity.ok("Đã xóa item " + id);
    }
}
