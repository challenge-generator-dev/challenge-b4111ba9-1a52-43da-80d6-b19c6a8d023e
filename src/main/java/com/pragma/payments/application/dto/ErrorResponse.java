package com.pragma.payments.application.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public record ErrorResponse(
    int status,
    String code,
    String message,
    LocalDateTime timestamp
) {
    public ErrorResponse {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("El código de error no puede ser nulo o vacío");
        }
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("El mensaje de error no puede ser nulo o vacío");
        }
        Objects.requireNonNull(timestamp, "El timestamp no puede ser nulo");
    }

    public static ErrorResponse of(int status, String code, String message) {
        return new ErrorResponse(status, code, message, LocalDateTime.now());
    }

    public static ErrorResponse badRequest(String message) {
        return new ErrorResponse(400, "BAD_REQUEST", message, LocalDateTime.now());
    }

    public static ErrorResponse notFound(String message) {
        return new ErrorResponse(404, "NOT_FOUND", message, LocalDateTime.now());
    }

    public static ErrorResponse internalError(String message) {
        return new ErrorResponse(500, "INTERNAL_SERVER_ERROR", message, LocalDateTime.now());
    }

    public static ErrorResponse unauthorized(String message) {
        return new ErrorResponse(401, "UNAUTHORIZED", message, LocalDateTime.now());
    }

    public static ErrorResponse forbidden(String message) {
        return new ErrorResponse(403, "FORBIDDEN", message, LocalDateTime.now());
    }

    public static ErrorResponse serviceUnavailable(String message) {
        return new ErrorResponse(503, "SERVICE_UNAVAILABLE", message, LocalDateTime.now());
    }

    public boolean isClientError() {
        return status >= 400 && status < 500;
    }

    public boolean isServerError() {
        return status >= 500;
    }

    public boolean isSuccess() {
        return status >= 200 && status < 300;
    }

    public String getStatusText() {
        return switch (status) {
            case 200 -> "OK";
            case 201 -> "Created";
            case 204 -> "No Content";
            case 400 -> "Bad Request";
            case 401 -> "Unauthorized";
            case 403 -> "Forbidden";
            case 404 -> "Not Found";
            case 500 -> "Internal Server Error";
            case 503 -> "Service Unavailable";
            default -> "Unknown";
        };
    }

    public ErrorResponse withStatus(int newStatus) {
        return new ErrorResponse(newStatus, code, message, timestamp);
    }

    public ErrorResponse withCode(String newCode) {
        return new ErrorResponse(status, newCode, message, timestamp);
    }

    public ErrorResponse withMessage(String newMessage) {
        return new ErrorResponse(status, code, newMessage, timestamp);
    }

    public ErrorResponse withTimestamp(LocalDateTime newTimestamp) {
        return new ErrorResponse(status, code, message, newTimestamp);
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "status=" + status +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}