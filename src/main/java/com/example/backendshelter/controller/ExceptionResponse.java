package com.example.backendshelter.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ExceptionResponse {
    private int status;
    private String Error;
    private LocalDateTime timestamp;
}
