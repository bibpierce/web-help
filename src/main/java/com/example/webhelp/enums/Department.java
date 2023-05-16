package com.example.webhelp.enums;

public enum Department {
    IT(1, "Information and Technology"),
    ADMIN(2, "Administrator"),
    HR(3, "Human Resource"),
    SALES(4, "Sales Management");

    Department(int id, String details) {
        this.id = id;
        this.details = details;
    }

    private int id;
    private String details;

}

