package com.idev.shop.controller;

import com.idev.shop.dto.CategoryDTO;
import com.idev.shop.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * CategoryController: Chịu trách nhiệm tiếp nhận và xử lý các yêu cầu HTTP liên quan đến Danh mục.
 * Class này đóng vai trò là "cổng vào" cho các API về Category.
 */
@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
@Tag(name = "Category Profile", description = "Các API liên quan đến danh mục sản phẩm")
public class CategoryController {

    private final CategoryService categoryService;

    /**
     * getAllCategories: Xử lý yêu cầu lấy toàn bộ danh mục.
     * @return ResponseEntity chứa danh sách các CategoryDTO và HTTP Status 200 (OK).
     */
    @GetMapping
    @Operation(summary = "Lấy danh sách tất cả các danh mục", description = "Trả về danh sách các danh mục rau củ hiện có trong hệ thống")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        // Gọi xuống tầng Service để lấy dữ liệu thay vì gọi trực tiếp Repository
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @PostMapping
    @Operation(summary = "Tạo mới một danh mục", description = "Dùng để thêm một loại danh mục rau củ mới vào hệ thống")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        // Placeholder: Logic lưu dữ liệu sẽ được viết ở Sprint sau
        return ResponseEntity.ok(categoryDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Cập nhật thông tin danh mục", description = "Cập nhật tên hoặc mô tả của danh mục đã tồn tại")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Integer id, @RequestBody CategoryDTO categoryDTO) {
        categoryDTO.setId(id);
        return ResponseEntity.ok(categoryDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Xóa một danh mục", description = "Xóa vĩnh viễn danh mục khỏi hệ thống theo ID")
    public ResponseEntity<String> deleteCategory(@PathVariable Integer id) {
        return ResponseEntity.ok("Đã xóa danh mục có ID: " + id);
    }
}
