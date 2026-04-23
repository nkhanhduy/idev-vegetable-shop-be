package com.idev.shop.dto;

import com.idev.shop.entity.Role;
import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String email;
    private String fullName;
    private Role role;
    private Boolean isActive;
    private LocalDateTime createdAt;
}
