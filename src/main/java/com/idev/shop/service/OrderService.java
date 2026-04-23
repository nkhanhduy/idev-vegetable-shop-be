package com.idev.shop.service;

import com.idev.shop.dto.OrderDTO;
import com.idev.shop.entity.Order;
import com.idev.shop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private OrderDTO convertToDTO(Order order) {
        return OrderDTO.builder()
                .id(order.getId())
                .userId(order.getUser().getId())
                .userFullName(order.getUser().getFullName())
                .status(order.getStatus())
                .totalAmount(order.getTotalAmount())
                .shippingAddress(order.getShippingAddress())
                .paymentMethod(order.getPaymentMethod())
                .paymentStatus(order.getPaymentStatus())
                .note(order.getNote())
                .createdAt(order.getCreatedAt())
                .updatedAt(order.getUpdatedAt())
                .build();
    }
}
