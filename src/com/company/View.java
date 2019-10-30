package com.company;

import java.util.Scanner;

public class View {

    //ENUMS - Strictly related to Class View.
    public enum MenuItem {
        MANAGE_POTIONS("Manage your personal potions."),
        EXPLORE_POTION_STORE("Explore the Potion Store."),
        SCROLL_QUIZ("Quiz: What scroll should you buy?"),
        SHOW_ALL_SCROLLS("Show all existing scrolls."),
        HELP("Help & Troubleshooting."),
        QUIT("Exit the program."),
        ;

        private String description;

        MenuItem(String description) {
            this.description = description;
        }
    }
    public enum SubMenuItem {
        ADD_POTION("Add a potion."),
        SHOW_ONE_POTION("Show a specific potion."),
        SHOW_ALL_POTIONS("Show the current list of potions."),
        SORT_POTIONS_BY_NAME("Sort your potions by name."),
        SORT_POTIONS_BY_PRICE("Sort your potions by price."),
        SAVE_POTIONS("Save the current list of potions."),
        REMOVE_POTION("Remove a potion from the list."),
        EXIT("Return to the Main Menu.");

        private String description;

        SubMenuItem(String description) {
            this.description = description;
        }
    }

    //FIELDS
    private static View instance = null;
    private Scanner input = new Scanner(System.in);

    //CONSTRUCTOR - It's private so no one can get at it!
    private View() {}

    //METHODS ----------------------------------------------------------------

    public static View getInstance() {
        //This method makes sure only one instance is created and used.
        if (instance == null) {
            instance = new View();
        }
        return instance;
    }

    public MenuItem showMainMenuAndGetChoice() {
        System.out.println("MAIN MENU\n---------------------");
        int menuNumber = 1; //Giving each menu item a corresponding key for the user to press.
        for (MenuItem menuItem : MenuItem.values()) {
            System.out.println(menuNumber + ". " + menuItem.description);
            menuNumber++;
        }
        int userChoice;
        do {
            userChoice = askUserToEnterInteger();
            if ((userChoice > MenuItem.values().length) || (userChoice < 1)){
                System.out.println("Incorrect input. Please enter one of the numbers shown above.");
            }
        } while ((userChoice > MenuItem.values().length) || (userChoice < 1));

        return MenuItem.values()[userChoice - 1]; //We add -1 because MenuItem 1 is located in place 0.
    }

    public SubMenuItem showSubMenuAndGetChoice() {
        System.out.println("SUB MENU - Manage your personal potions\n---------------------");
        int subMenuNumber = 1; //Giving each menu item a corresponding key for the user to press.
        for (SubMenuItem subMenuItem : SubMenuItem.values()) {
            System.out.println(subMenuNumber + ". " + subMenuItem.description);
            subMenuNumber++;
        }

        int userChoice;
        do {
            userChoice = askUserToEnterInteger();
            if ((userChoice > SubMenuItem.values().length) || (userChoice < 1)){
                System.out.println("Incorrect input. Please enter one of the numbers shown above.");
            }
        } while ((userChoice > SubMenuItem.values().length) || (userChoice < 1));
        return SubMenuItem.values()[userChoice - 1]; //We add -1 because SubMenuItem 1 is located in place 0.
    }

    public Potion askUserToAddAPotion() {
        System.out.println("Enter the name of the Potion:");
        String potionName = input.nextLine();
        System.out.println("Describe the potion:");
        String potionDescription = input.nextLine();
        System.out.println("Enter the price of the potion:");
        double potionPrice = askUserToEnterDouble();
        return new Potion(potionName, potionDescription, potionPrice);
    }

    public String askUserWhatPotionToRemove(){
        System.out.println("Write the name of the potion you'd like to remove:");
        return input.nextLine();
    }

    public String askUserWhatPotionToShow(){
        System.out.println("Write the name of the potion you'd like to see:");
        return input.nextLine();
    }

    //Only used to get userInput in the MagicStoreAdventure Class
    public String getUserDecision(){
        return input.nextLine();
    }

    public int askUserToEnterInteger(){
        int userInt;
        while (true){
            try{
                userInt = Integer.parseInt(input.nextLine());
                return userInt;
            }
            catch (Exception e){
                System.out.println("Incorrect input. Try again.");
            }
        }
    }

    public double askUserToEnterDouble(){
        double userDouble;
        while (true){
            try{
                userDouble = Double.parseDouble(input.nextLine());
                return userDouble;
            }
            catch (Exception e){
                System.out.println("Incorrect input (Remember: Comma's don't work in the console, use a \".\" for decimals instead).");
            }
        }
    }

}
