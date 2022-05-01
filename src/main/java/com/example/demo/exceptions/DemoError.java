package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Date;

public class DemoError extends ResponseEntity {
    public DemoError(String message, HttpStatus status) {
        super(String.format("<http>Exception:<br> %s <br>Status: %s <hr>Date: %s", message, status, new Date()), status);
    }
}
