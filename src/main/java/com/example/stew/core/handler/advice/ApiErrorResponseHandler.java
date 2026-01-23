package com.example.stew.core.handler.advice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.stew.core.api.dto.ApiResponse;
import com.example.stew.core.api.dto.Message;
import com.example.stew.core.exception.UnauthorizedException;

@RestControllerAdvice
public class ApiErrorResponseHandler {

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ApiResponse<Void>> handleUnauthorized(UnauthorizedException ex) {
        ApiResponse<Void> response = new ApiResponse<Void>(null);
        Message message = new Message();
        message.setLevel("error");
        message.setMessage(ex.getMessage());
        List<Message> messages = new ArrayList<Message>();
        messages.add(message);
        response.setMessages(messages);
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(response);
    }
}
