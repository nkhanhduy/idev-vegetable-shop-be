package com.idev.shop.controller;

import com.idev.shop.dto.OrderDTO;
import com.idev.shop.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@Tag(name = "Order Profile", description = "Các API liên quan đến đơn hàng và thanh toán")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    @Operation(summary = "Lấy danh sách tất cả đơn hàng", description = "Trả về lịch sử toàn bộ các đơn đặt hàng")
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Xem chi tiết một đơn hàng")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
        // Trả về một DTO rỗng làm mẫu
        return ResponseEntity.ok(new OrderDTO());
    }

    @PostMapping("/{id}/payment")
    @Operation(summary = "Thanh toán đơn hàng (Mock)")
    public ResponseEntity<String> processPayment(@PathVariable Long id) {
        return ResponseEntity.ok("Thanh toán thành công cho đơn " + id);
    }
}
