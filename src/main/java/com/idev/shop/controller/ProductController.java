package com.idev.shop.controller;

import com.idev.shop.dto.ProductDTO;
import com.idev.shop.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ProductController: Chịu trách nhiệm tiếp nhận và xử lý các yêu cầu HTTP liên quan đến Sản phẩm.
 */
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Tag(name = "Product Profile", description = "Các API liên quan đến sản phẩm rau củ quả")
public class ProductController {

    private final ProductService productService;

    /**
     * getAllProducts: Xử lý yêu cầu lấy danh sách toàn bộ sản phẩm.
     * @return ResponseEntity chứa danh sách ProductDTO.
     */
    @GetMapping
    @Operation(summary = "Lấy danh sách tất cả các sản phẩm", description = "Trả về danh sách toàn bộ các loại rau củ quả có trong shop")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        // Thực hiện lấy dữ liệu thông qua ProductService
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Xem chi tiết một sản phẩm")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(new ProductDTO());
    }

    @PostMapping
    @Operation(summary = "Thêm một sản phẩm mới", description = "Thêm một loại rau củ quả mới vào kho hàng")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Cập nhật thông tin sản phẩm", description = "Thay đổi giá, số lượng tồn kho hoặc thông tin sản phẩm")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        productDTO.setId(id);
        return ResponseEntity.ok(productDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Xóa sản phẩm", description = "Xóa sản phẩm khỏi danh mục kinh doanh")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok("Đã xóa sản phẩm có ID: " + id);
    }

    @PostMapping("/{id}/reviews")
    @Operation(summary = "Đánh giá sản phẩm")
    public ResponseEntity<String> addReview(@PathVariable Long id) {
        return ResponseEntity.ok("Đã lưu đánh giá cho sản phẩm " + id);
    }
}
