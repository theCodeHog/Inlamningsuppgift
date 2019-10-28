package com.company;

import java.io.Serializable;

public class Scroll extends ItemForSale {

    //CONSTRUCTOR
    public Scroll(String name, String description, double price){
        super(name, description, price);
    }

    //METHODS ----------------------------------------------------------------

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public String toString() {
        return "\nName: " + getName() +
                "\nDescription: " + getDescription() +
                "\nPrice: " + getPrice() +
                "\n";
    }

    @Override
    public void showTypeOfItem() {
        System.out.println("Type of item: Scroll");
    }
}
