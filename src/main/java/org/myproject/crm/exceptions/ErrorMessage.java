package org.myproject.crm.exceptions;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorMessage {
    private int statusCode;
    private LocalDateTime timeStamp;
    private String message;
}
