package com.example.springdemo.dto;

public record DatabasePoolResponse(
    String poolName,
    int totalConnections,
    int activeConnections,
    int idleConnections,
    int threadsAwaitingConnection,
    int maximumPoolSize,
    int minimumIdle,
    long connectionTimeoutMs,
    String status) {
}