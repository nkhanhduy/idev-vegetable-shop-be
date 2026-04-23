package com.idev.shop.dto;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private Integer categoryId;
    private String categoryName;
    private String name;
    private String description;
    private BigDecimal price;
    private String unit;
    private Integer stockQty;
    private String imageUrl;
    private Boolean isActive;
    private LocalDateTime createdAt;
}
