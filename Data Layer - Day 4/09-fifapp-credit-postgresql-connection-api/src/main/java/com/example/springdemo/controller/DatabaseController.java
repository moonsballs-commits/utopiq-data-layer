package com.example.springdemo.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.springdemo.dto.DatabaseStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class DatabaseController {
    private final JdbcTemplate jdbcTemplate;

    public DatabaseController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/api/database/ping")
    public DatabaseStatus pingDatabase() {
        String databaseName = jdbcTemplate.queryForObject("select current_database()", String.class);

        return new DatabaseStatus(
            true,
            databaseName,
            "PostgresSQL connection is ok"
        );
    }
}
