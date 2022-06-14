package com.example;

import com.opencsv.bean.CsvBindByName;

public class Account {
    @CsvBindByName
    private final String id;
    @CsvBindByName
    private final String name;

    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
