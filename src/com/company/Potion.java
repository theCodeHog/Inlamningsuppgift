package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Potion extends ItemForSale implements Comparable<Potion> {

    public enum SortBy {
        NAME,
        PRICE,
    }

    //FIELDS
    private static SortBy sortBy = SortBy.NAME;

    //CONSTRUCTOR
    Potion(String name, String description, double price) {
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
        System.out.println("Type of item: Potion");
    }

    static void setSortBy(SortBy sortBy) {
        Potion.sortBy = sortBy;
    }

    public int compareTo(Potion potion) {
        if (sortBy == SortBy.PRICE) {
            return (int) (getPrice() - potion.getPrice());
        }
        return (getName().compareTo(potion.getName()));
    }

}
