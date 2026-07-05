package com.example.springdemo.database;

public class DatabaseStatus {
    private boolean connected;
    private String databaseName;
    private String message;

    public DatabaseStatus(boolean connected, String databaseName, String message) {
        this.connected = connected;
        this.databaseName = databaseName;
        this.message = message;
    }

    public boolean isConnected() {return connected;}
    public String getDatabaseName() {return databaseName;}
    public String getMessage() {return message;}
}
