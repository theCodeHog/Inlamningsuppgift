package com.company;

import java.io.Serializable;

public abstract class ItemForSale implements Serializable {

    //FIELDS
    private String name;
    private String description;
    private double price;

    //CONSTRUCTOR
    public ItemForSale(String name, String description, double price){
        this.name = name;
        this.description = description;
        this.price = price;
    }

    //METHODS ----------------------------------------------------------------

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}
