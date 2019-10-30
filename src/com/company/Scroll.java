package com.company;

import java.io.Serializable;

public class Scroll extends ItemForSale {

    //CONSTRUCTOR
    public Scroll(String name, String description, double price){
        super(name, description, price);
    }

    //METHODS ----------------------------------------------------------------

    @Override
    public String toString() {
        return String.format("\nName: %s \nDescription: %s \nPrice: %.2f \n", getName(), getDescription(), getPrice());
    }

    @Override
    public void showTypeOfItem() {
        System.out.println("Type of item: Scroll");
    }
}
