package com.company;

import potionStoreExtras.MagicStoreAdventure;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

/**
 * <h2>Magic Store Program</h2>
 * The MagicStore program implements an application that
 * manages the potions of a Magic Store.
 *
 * @author Paola Tosca van den Bor
 * @version 1.0
 * @since 2019-10-01
 */

public class MagicStoreProgram {

    //FIELDS
    ArrayList<Potion> potions;
    ArrayList<Scroll> scrolls;
    private Quiz quiz = new Quiz();

    /**
     * The constructor checks if a previously saved file of
     * potions is available. If not, it loads the game/program with
     * a general set of potions.
     */
    //CONSTRUCTOR
    public MagicStoreProgram() {
        if (Files.exists(Paths.get("potions.ser"))) {
            potions = new ArrayList<Potion>(FileUtils.readObjects("potions.ser"));
            System.out.println("Starting the program with your latest list of Potions.\n");
        } else {
            potions = new ArrayList<>();
            try {
                ArrayList<String> standardPotions = (ArrayList<String>) FileUtils.readAllLines("listOfStandardPotions.txt");
                for (String standardPotion : standardPotions) {
                    String[] temp = standardPotion.split(";");
                    potions.add(new Potion(temp[0], temp[1], Double.parseDouble(temp[2])));
                }
                System.out.println("Starting the program with 10 standard potions in your list.\n");
            }
            catch (Exception e){
                System.out.println("An error occurred: "+e);
            }
        }
    }

    //METHODS ----------------------------------------------------------------

    //MAIN MENU METHODS

    /**
     * Starts the program
     */
    public void startProgram() {

        System.out.println("Welcome to the Magic Store!" +
                "\nCurrently selling potions and scrolls.\n");

        boolean isRunning = true;
        while (isRunning) {

            switch (View.getInstance().showMainMenuAndGetChoice()) {
                case MANAGE_POTIONS:
                    enterSubMenu();
                    break;
                case EXPLORE_POTION_STORE:
                    exploreThePotionsStore();
                    break;
                case SCROLL_QUIZ:
                    whatScrollShouldYouBuyQuiz();
                    break;
                case SHOW_ALL_SCROLLS:
                    showAllScrolls();
                    break;
                case HELP:
                    help();
                    break;
                case QUIT:
                    System.out.println("Closing program...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Incorrect input. Please enter one of the numbers shown above.");
            }
        }
    }

    /**
     * Shows the submenu, where the user can manage their potions.
     */
    public void enterSubMenu() {

        boolean isSubMenuRunning = true;
        while (isSubMenuRunning) {

            switch (View.getInstance().showSubMenuAndGetChoice()) {
                case ADD_POTION:
                    addPotion();
                    break;
                case SHOW_ONE_POTION:
                    showOnePotion();
                    break;
                case SHOW_ALL_POTIONS:
                    showAllPotions();
                    break;
                case SORT_POTIONS_BY_NAME:
                    sortPotionsByName();
                    break;
                case SORT_POTIONS_BY_PRICE:
                    sortPotionsByPrice();
                    break;
                case SAVE_POTIONS:
                    saveCurrentPotionsList();
                    break;
                case REMOVE_POTION:
                    removePotion();
                    break;
                case EXIT:
                    isSubMenuRunning = false;
                    break;
                default:
                    System.out.println("Incorrect input. Please enter one of the numbers shown above.");
            }
        }
    }

    public void exploreThePotionsStore() {
        MagicStoreAdventure magicStoreAdventure = new MagicStoreAdventure();
        magicStoreAdventure.startAdventure();
    } //TODO: WIP

    /**
     * Extra: A Quiz that checks what scroll you should buy based on your personality.
     */
    public void whatScrollShouldYouBuyQuiz() {
        quiz.runWhatScrollIsBestForYouQuiz();
    }

    /**
     * Shows all scrolls that one could get as a result from the Quiz.
     */
    public void showAllScrolls() {
        scrolls = new ArrayList<>();
        try {
            ArrayList<String> standardScrolls = (ArrayList<String>) FileUtils.readAllLines("scrolls.txt");
            for (String scroll : standardScrolls) {
                String[] temp = scroll.split(";");
                scrolls.add(new Scroll(temp[0], temp[1], Double.parseDouble(temp[2])));
            }
        } catch (Exception e) {
            System.out.println("Error occurred. " + e);
        }
        System.out.println(scrolls.toString().replace("[", "").replace("]", "").replace(",", "."));
    }

    /**
     * This is where the help menu would be located. (Currently the help menu is not much help).
     */
    public void help() {
        System.out.println("You are looking for help & troubleshooting. I recommend www.google.com.\n");
    }


    //SUBMENU METHODS

    /**
     * Add a potion to the list potions.
     */
    public void addPotion() {
        Potion newpotion = View.getInstance().askUserToAddAPotion();
        potions.add(newpotion);
        System.out.println("A new potion has been added to the list.");
    }

    /**
     * Shows one potion with all it's details from the list potions.
     */
    public void showOnePotion() {
        String potionName = View.getInstance().askUserWhatPotionToShow();
        boolean isFound = false;

        for (Potion potion : potions) {
            if (potionName.equalsIgnoreCase(potion.getName())) {
                potion.showTypeOfItem();
                System.out.println(potion.toString());
                isFound = true;
                break;
            }
        }

        if (!isFound) {
            System.out.println("The potion you entered doesn't exist.\nReturning to menu...\n");
        }

    }

    /**
     * Shows all potions with all their details from the list potions.
     */
    public void showAllPotions() {
        System.out.println(potions.toString().replace("[", "").replace("]", "").replace(",", "."));
    }

    /**
     * Sorts all potions in the list potions by name.
     */
    public void sortPotionsByName() {
        Potion.setSortBy(Potion.SortBy.NAME);
        Collections.sort(potions);
        System.out.println("The potions have been sorted by name.\n");
    }

    /**
     * Sorts all potions in the list potions by name.
     */
    public void sortPotionsByPrice() {
        Potion.setSortBy(Potion.SortBy.PRICE);
        Collections.sort(potions);
        System.out.println("The potions have been sorted by price.\n");
    }

    /**
     * Save your current list of potions, it'll load the next time the program starts.
     */
    public void saveCurrentPotionsList() {
        if (Files.exists(Paths.get("potions.ser"))) {
            try {
                new FileOutputStream("potions.ser").close();
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
        FileUtils.writeObjects(potions, "potions.ser");
        System.out.println("Your current list of potions has been saved.\n");
    }

    /**
     * Removes a chosen potion from the list potions.
     */
    public void removePotion() {

        //Showing list of current potion names first.
        System.out.println("Current potions:");
        for (Potion potion : potions) {
            System.out.println(potion.getName());
        }

        String potionName = View.getInstance().askUserWhatPotionToRemove();
        boolean isFound = false;

        for (Potion potion : potions) {
            if (potionName.equalsIgnoreCase(potion.getName())) {
                potions.remove(potion);
                System.out.println("The following potion has been removed: " + potion.getName() + "\n");
                isFound = true;
                break;
            }
        }

        if (!isFound) {
            System.out.println("The potion you entered doesn't exist and no potion was removed. \nReturning to menu...\n");
        }
    }

}
