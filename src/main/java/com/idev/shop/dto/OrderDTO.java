package com.idev.shop.dto;

import com.idev.shop.entity.OrderStatus;
import com.idev.shop.entity.PaymentStatus;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private Long userId;
    private String userFullName;
    private OrderStatus status;
    private BigDecimal totalAmount;
    private String shippingAddress;
    private String paymentMethod;
    private PaymentStatus paymentStatus;
    private String note;
    private List<OrderItemDTO> items;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
