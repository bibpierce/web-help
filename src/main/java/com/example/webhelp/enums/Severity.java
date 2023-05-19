package com.example.webhelp.enums;

public enum Severity {
    LOW(0), NORMAL(1), MAJOR(2), CRITICAL(3);

    private int id;

    Severity(int id){
        this.id = id;
    }
}
