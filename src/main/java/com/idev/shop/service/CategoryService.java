package com.idev.shop.service;

import com.idev.shop.dto.CategoryDTO;
import com.idev.shop.entity.Category;
import com.idev.shop.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * CategoryService: Xử lý logic nghiệp vụ cho Danh mục.
 * Đóng vai trò cầu nối giữa Controller (Giao diện) và Repository (Cơ sở dữ liệu).
 */
@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    /**
     * getAllCategories: Lấy tất cả danh mục và chuyển đổi chúng thành DTO.
     * @return Danh sách các CategoryDTO.
     */
    public List<CategoryDTO> getAllCategories() {
        // Lấy tất cả Entity từ DB, sau đó dùng Stream API để chuyển từng Entity sang DTO
        return categoryRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * convertToDTO: Hàm hỗ trợ chuyển đổi từ đối tượng Entity (Category) sang DTO (CategoryDTO).
     * Điều này giúp bảo mật và chỉ trả về những dữ liệu cần thiết cho Frontend.
     */
    private CategoryDTO convertToDTO(Category category) {
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .createdAt(category.getCreatedAt())
                .build();
    }
}
