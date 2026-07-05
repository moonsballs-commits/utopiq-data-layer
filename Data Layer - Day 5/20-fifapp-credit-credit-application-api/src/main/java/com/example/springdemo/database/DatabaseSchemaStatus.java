package com.example.springdemo.database;

import java.util.List;

public class DatabaseSchemaStatus {
    private String schemaName;
    private List<String> tables;
    private String message;

    public DatabaseSchemaStatus(String schemaName, List<String> tables, String message) {
        this.schemaName = schemaName;
        this.tables = tables;
        this.message = message;
    }

    public String getSchemaName() {return schemaName;}
    public List<String> getTables() {return tables;}
    public String getMessage() {return message;}
}
