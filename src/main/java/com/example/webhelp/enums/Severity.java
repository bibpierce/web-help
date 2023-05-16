package com.example.webhelp.enums;

public enum Severity {
    LOW(1), NORMAL(2), MAJOR(3), CRITICAL(4);

    private int id;

    Severity(int id){
        this.id = id;
    }
}
