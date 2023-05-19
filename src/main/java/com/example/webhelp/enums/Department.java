package com.example.webhelp.enums;

public enum Department {
    IT(0, "Information and Technology"),
    ADMIN(1, "Administrator"),
    HR(2, "Human Resource"),
    SALES(3, "Sales Management");

    Department(int id, String details) {
        this.id = id;
        this.details = details;
    }

    private int id;
    private String details;

}

