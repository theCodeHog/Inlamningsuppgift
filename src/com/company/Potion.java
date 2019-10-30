package com.company;

public class Potion extends ItemForSale implements Comparable<Potion> {

    public enum SortBy {
        NAME,
        PRICE,
    }

    //FIELDS
    private static SortBy sortBy = SortBy.NAME;

    //CONSTRUCTOR
    public Potion(String name, String description, double price) {
        super(name, description, price);
    }

    //METHODS ----------------------------------------------------------------

    @Override
    public String toString() {
        return String.format("\nName: %s \nDescription: %s \nPrice: %.2f \n", getName(), getDescription(), getPrice());
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
