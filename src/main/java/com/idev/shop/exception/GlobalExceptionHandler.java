package com.idev.shop.exception;

import com.idev.shop.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

/**
 * GlobalExceptionHandler: Bộ xử lý lỗi tập trung cho toàn bộ ứng dụng.
 * Bất kỳ lỗi nào xảy ra trong quá trình chạy sẽ được class này "bắt" lại
 * và trả về format chung cho Frontend thay vì hiện lỗi trắng màn hình.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * handleResourceNotFoundException: Xử lý riêng các trường hợp tìm không thấy dữ liệu.
     * @param ex Ngoại lệ ResourceNotFoundException.
     * @return Thông báo lỗi định dạng ErrorResponse với status 404.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorResponse error = ErrorResponse.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    /**
     * handleGeneralException: Xử lý tất cả các lỗi không xác định khác (Lỗi 500).
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        ErrorResponse error = ErrorResponse.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("Có lỗi xảy ra: " + ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
