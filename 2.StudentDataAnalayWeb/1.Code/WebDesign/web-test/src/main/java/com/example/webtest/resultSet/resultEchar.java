package com.example.webtest.resultSet;

public class resultEchar {
    private String name;
    private String value;

    public resultEchar (String name, String va) {
        super();
        this.name = name;
        this.value = va;
    }
// getter和setter以及toString略

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
