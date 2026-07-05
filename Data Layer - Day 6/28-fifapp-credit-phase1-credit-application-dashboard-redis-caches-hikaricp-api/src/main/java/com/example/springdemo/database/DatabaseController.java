package com.example.springdemo.database;

import org.springframework.web.bind.annotation.RestController;
import com.example.springdemo.dto.DatabasePoolResponse;
import com.example.springdemo.service.DatabasePoolService;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class DatabaseController {
    private final JdbcTemplate jdbcTemplate;
    private final DatabasePoolService databasePoolService;

    public DatabaseController(JdbcTemplate jdbcTemplate, DatabasePoolService databasePoolService) {
        this.jdbcTemplate = jdbcTemplate;
        this.databasePoolService = databasePoolService;
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

    @GetMapping("/api/database/schema")
    public DatabaseSchemaStatus getDatabaseSchema() {
        List<String> tables = jdbcTemplate.queryForList(
            """
            select table_name
            from information_schema.tables
            where table_schema = 'flyway_training'
            order by table_name
            """,
            String.class);
            
            return new DatabaseSchemaStatus(
                "flyway_training",
                tables,
                "Flyway migration has prepared the database schema");
    }
    
    @GetMapping("/api/database/customers")
    public List<DatabaseCustomerRow> getDatabaseCistomers() {
        return jdbcTemplate.query(
            """
            select id, full_name, phone_number, email
            from flyway_training.customers
            order by id
            """,
            (rs, rowNum) -> new DatabaseCustomerRow(
                rs.getLong("id"),
                rs.getString("full_name"),
                rs.getString("phone_number"),
                rs.getString("email")
            )
        );
    }

    @GetMapping("/api/database/pool")
    public DatabasePoolResponse getPool() {
        return databasePoolService.getPoolStatus();
    }

    @GetMapping("/api/database/pool/hold")
    public String holdConnection(@RequestParam(defaultValue = "5000")long durationMs) {
    return databasePoolService.holdConnection(durationMs);
    }
} 
