package com.example.webhelp.enums;

import lombok.Getter;

@Getter
public enum Department {
    IT(0, "Information and Technology"),
    ADMIN(1, "Administrator"),
    HR(2, "Human Resource"),
    SALES(3, "Sales Management");

    Department(Integer id, String details) {
        this.id = id;
        this.detail = details;
    }

    private Integer id;
    private String detail;


}

