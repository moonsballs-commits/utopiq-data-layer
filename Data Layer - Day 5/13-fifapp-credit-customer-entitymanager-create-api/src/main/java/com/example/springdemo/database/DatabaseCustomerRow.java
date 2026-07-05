package com.example.springdemo.database;

public class DatabaseCustomerRow {
    private Long id;
    private String fullName;
    private String phoneNumber;
    private String email;

    public DatabaseCustomerRow(Long id, String fullName, String phoneNumber, String email) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Long getId() {return id;}
    public String getFullName() {return fullName;}
    public String getPhoneNumber() {return phoneNumber;}
    public String getEmail() {return email;}
}
