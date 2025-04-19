package com.user_management.exceptions.handler;

import com.user_management.exceptions.model.ErrorItem;
import com.user_management.exceptions.model.ErrorResponse;
import com.user_management.exceptions.model.ResourceNotFoundException;
import com.user_management.exceptions.model.ApiResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> customExceptionHandler(ResourceNotFoundException ex){
        String message = ex.getMessage();
        ApiResponse response = new ApiResponse(message,true);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }

//    private ResponseEntity<Object> handle(
//            EmployerDetailsException ex, HttpStatus status, WebRequest request) {
//        return handle(ex, ex.getErrors(), status, request);
//    }
//
//    private ResponseEntity<Object> handle(
//            Exception ex, List<ErrorItem> errors, HttpStatus status, WebRequest request) {
//        var body = buildBody(errors);
//        return handleExceptionInternal(ex, body, new HttpHeaders(), status, request);
//    }
//
//    private ErrorResponse buildBody(List<ErrorItem> errors) {
//        var response = ErrorResponse.builder().build();
//        response.getErrors().addAll(errors);
//        return response;
//    }
}
