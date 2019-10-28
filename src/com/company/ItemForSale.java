package com.company;

import java.io.Serializable;

/**
 * <h2>Item For Sale</h2>
 * An abstract superclass that all items that can be for sale
 * in the store will inherit variables and methods from.
 */

public abstract class ItemForSale implements Serializable {

    //FIELDS
    private String name;
    private String description;
    private double price;

    /**
     * The constructor demands three values to be entered immediately when called upon.
     * (The subclasses will be making use of this as the superclass can not be called upon.)
     * @param name The name of the item
     * @param description The description of the item
     * @param price The price of the item
     */
    //CONSTRUCTOR
    public ItemForSale(String name, String description, double price){
        this.name = name;
        this.description = description;
        this.price = price;
    }

    //METHODS ----------------------------------------------------------------

    /**
     * @return private field name
     */
    public String getName() {
        return name;
    }

    /**
     * @return private field description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return private field price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Abstract method that all subclasses will inherit and prints what kind of item the subclass is.
     */
    public abstract void showTypeOfItem();

}
