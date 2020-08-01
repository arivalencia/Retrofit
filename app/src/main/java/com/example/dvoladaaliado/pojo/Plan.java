package com.example.dvoladaaliado.pojo;

public class Plan {
    String name;
    String description;
    int price;

    public Plan(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }
}
