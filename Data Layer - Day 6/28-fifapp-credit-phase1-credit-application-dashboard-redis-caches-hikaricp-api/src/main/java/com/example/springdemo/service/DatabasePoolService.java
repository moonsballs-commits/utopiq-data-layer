package com.example.springdemo.service;

import java.sql.Connection;
import org.springframework.stereotype.Service;
import com.example.springdemo.dto.DatabasePoolResponse;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariPoolMXBean;

@Service
public class DatabasePoolService {
    private final HikariDataSource hikariDataSource;

    public DatabasePoolService(HikariDataSource hikariDataSource) {
        this.hikariDataSource = hikariDataSource;
    }

    public DatabasePoolResponse getPoolStatus() {
        HikariPoolMXBean pool = hikariDataSource.getHikariPoolMXBean();
        return new DatabasePoolResponse(
            hikariDataSource.getPoolName(),
            pool.getTotalConnections(),
            pool.getActiveConnections(),
            pool.getIdleConnections(),
            pool.getThreadsAwaitingConnection(),
            hikariDataSource.getMaximumPoolSize(),
            hikariDataSource.getMinimumIdle(),
            hikariDataSource.getConnectionTimeout(),"running");
    }

    public String holdConnection(long durationMs) {
        try (Connection connection = hikariDataSource.getConnection()) {
            connection.prepareStatement("select 1").execute();
            Thread.sleep(durationMs);
            return "Connection held for " + durationMs + " ms";
        } catch (Exception exception) {
            throw new RuntimeException(
                "Failed to hold database connection", exception);
        }
    }
}