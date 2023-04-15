package com.game.reviews.microservice.exceptions;

import com.game.reviews.microservice.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ReviewNotFoundException.class)
    ResponseEntity<ApiResponse> handleReviewNotFoundException(ReviewNotFoundException ex){
        ApiResponse response = ApiResponse.builder().message(ex.getMessage()).isSuccess(false).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
    }
}
