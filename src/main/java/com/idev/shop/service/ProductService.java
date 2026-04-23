package com.idev.shop.service;

import com.idev.shop.dto.ProductDTO;
import com.idev.shop.entity.Product;
import com.idev.shop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ProductService: Xử lý logic nghiệp vụ cho Sản phẩm.
 */
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    /**
     * getAllProducts: Lấy danh sách toàn bộ sản phẩm.
     * @return Danh sách ProductDTO.
     */
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * convertToDTO: Chuyển đổi từ Entity Product sang DTO ProductDTO.
     * Lưu ý: Thực hiện kiểm tra null cho Category để tránh lỗi NullPointerException
     * khi sản phẩm không có danh mục.
     */
    private ProductDTO convertToDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .categoryId(product.getCategory() != null ? product.getCategory().getId() : null)
                .categoryName(product.getCategory() != null ? product.getCategory().getName() : "N/A")
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .unit(product.getUnit())
                .stockQty(product.getStockQty())
                .imageUrl(product.getImageUrl())
                .isActive(product.getIsActive())
                .createdAt(product.getCreatedAt())
                .build();
    }
}
