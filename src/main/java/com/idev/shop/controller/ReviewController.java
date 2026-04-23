package com.idev.shop.controller;

import com.idev.shop.dto.ReviewDTO;
import com.idev.shop.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
@Tag(name = "Review Profile", description = "Các API liên quan đến đánh giá và bình luận")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    @Operation(summary = "Lấy danh sách tất cả đánh giá", description = "Trả về toàn bộ các lượt rating và comment của khách hàng")
    public ResponseEntity<List<ReviewDTO>> getAllReviews() {
        return ResponseEntity.ok(reviewService.getAllReviews());
    }
}
