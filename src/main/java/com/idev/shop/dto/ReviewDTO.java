package com.idev.shop.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private Long id;
    private Long userId;
    private String userFullName;
    private Long productId;
    private String productName;
    private Integer rating;
    private String comment;
    private LocalDateTime createdAt;
}
