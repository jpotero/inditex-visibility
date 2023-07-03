package com.inditex.visibility.error;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class ErrorMessage {
    private int statusCode;
    private OffsetDateTime timestamp;
    private String message;
    private String description;
}
