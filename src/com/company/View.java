package com.company;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class View {

    //ENUMS - Strictly related to Class View.
    public enum MenuItem {
        MANAGE_POTIONS("Manage your personal potions."),
        EXPLORE_POTION_STORE("Explore the Potion Store."),
        POTION_QUIZ("Quiz: What potion is best for you?"),
        QUIT("Quit the program."),
        ;

        private String description;

        MenuItem(String description) {
            this.description = description;
        }
    }
    public enum SubMenuItem {
        ADD_POTIONS("Add potions."),
        SHOW_ALL_POTIONS("Show the current list of potions."),
        SORT_POTIONS_BY_NAME("Sort your potions by name."),
        SORT_POTIONS_BY_PRICE("Sort your potions by price."),
        SAVE_POTIONS("Save the current list of potions."),
        REMOVE_POTIONS("Remove potions from the list."),
        EXIT("Return to the Main Menu.");

        private String description;

        SubMenuItem(String description) {
            this.description = description;
        }
    }

    //FIELDS
    private static View instance = null;
    Scanner input = new Scanner(System.in);

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
            userChoice = FileUtils.askUserToEnterInteger();
        } while ((userChoice > MenuItem.values().length-1) || (userChoice < 1) );

        return MenuItem.values()[userChoice - 1]; //We add -1 because MenuItem 1 is located in place 0.
    }

    public SubMenuItem showSubMenuAndGetChoice() {
        System.out.println("SUB MENU - Manage your personal potions\n---------------------");
        int subMenuNumber = 1; //Giving each menu item a corresponding key for the user to press.
        for (SubMenuItem subMenuItem : SubMenuItem.values()) {
            System.out.println(subMenuNumber + ". " + subMenuItem.description);
            subMenuNumber++;
        }

        int userChoice = FileUtils.askUserToEnterInteger();
        return SubMenuItem.values()[userChoice - 1]; //We add -1 because SubMenuItem 1 is located in place 0.
    }

    public Potion askUserToAddAPotion() {
        System.out.println("Enter the name of the Potion:");
        String potionName = input.nextLine();
        System.out.println("Describe the potion:");
        String potionDescription = input.nextLine();
        System.out.println("Enter the price of the potion:");
        int potionPrice = Integer.parseInt(input.nextLine());
        return new Potion(potionName, potionDescription, potionPrice);
    }

    public int askUserWhatAmountOfPotionsToRemove() {
        System.out.println("How many potions would you like to remove?");
        int amountOfPotionsToRemove = FileUtils.askUserToEnterInteger();
        return amountOfPotionsToRemove;
    }

    public String askUserWhatPotionToRemove(){
        System.out.println("Write the name of the potion you'd like to remove:");
        String potionName = input.nextLine();
        return potionName;
    }

    public void potionQuiz(){

    }

    public String getUserDecision(){
        String userDecision = input.nextLine();
        return userDecision;
    }


}
