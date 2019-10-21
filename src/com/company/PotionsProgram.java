package com.company;

import potionStoreExtras.PotionStoreAdventure;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class PotionsProgram {

    //FIELDS
    ArrayList<Potion> potions;

    //CONSTRUCTOR
    public PotionsProgram(){
        if (Files.exists(Paths.get("potions.ser"))) {
            potions = new ArrayList<Potion>(FileUtils.readObjects("potions.ser"));
            System.out.println("Starting the program with your latest list of Potions.");
        } else {
            potions = new ArrayList<>();
            ArrayList<String> standardPotions = (ArrayList<String>) FileUtils.readAllLines ("listOfStandardPotions.txt");
            for (String standardPotion : standardPotions) {
                String temp[] = standardPotion.split(";");
                potions.add(new Potion(temp[0], temp[1], Double.parseDouble(temp[2])));
            }
            System.out.println("Starting the program with 10 standard potions in your list.");
        }
    }

    //METHODS ----------------------------------------------------------------

    public void startProgram() {

        System.out.println("Welcome to Potions Paradise!");

        boolean isRunning = true;
        while (isRunning) {

            switch (View.getInstance().showMainMenuAndGetChoice()){
                case MANAGE_POTIONS:
                    enterSubMenu();
                    break;
                case EXPLORE_POTION_STORE:
                    exploreThePotionsStore();
                    break;
                case POTION_QUIZ:
                    whatPotionIsBestForYouTest();
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

    public void enterSubMenu() {

        boolean isSubMenuRunning = true;
        while (isSubMenuRunning) {

            switch (View.getInstance().showSubMenuAndGetChoice()){
                case ADD_POTIONS:
                    addPotion();
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
                case REMOVE_POTIONS:
                    removePotions();
                    break;
                case EXIT:
                    isSubMenuRunning = false;
                    break;
                default:
                    System.out.println("Incorrect input. Please enter one of the numbers shown above.");
            }
        }
    }

    public void exploreThePotionsStore(){
        PotionStoreAdventure potionStoreAdventure = new PotionStoreAdventure();
        potionStoreAdventure.startAdventure();
    } //TODO: WIP

    public void whatPotionIsBestForYouTest(){
        System.out.println("Under construction!");
    } //TODO

    public void addPotion(){
        Potion newpotion = View.getInstance().askUserToAddAPotion();
        potions.add(newpotion);
        System.out.println("A new potion has been added to the list.");
    }

    public void showAllPotions(){
            System.out.println(potions.toString().replace("[","").replace("]","").replace(",","-"));
    }

    public void sortPotionsByName(){
        Potion.setSortBy(Potion.SortBy.NAME);
        Collections.sort(potions);
        System.out.println("The potions have been sorted by name.");
    }

    public void sortPotionsByPrice(){
        Potion.setSortBy(Potion.SortBy.PRICE);
        Collections.sort(potions);
        System.out.println("The potions have been sorted by price.");
    }

    public void saveCurrentPotionsList() {
        if (Files.exists(Paths.get("potions.ser"))) {
            try {
                new FileOutputStream("potions.ser").close();
            }
            catch (Exception e){
                System.out.println("Error: "+e);
            }
        }
        FileUtils.writeObjects(potions, "potions.ser");
    }

    public void removePotions(){
        System.out.println("Current potions:");
        for (Potion potion : potions){
            System.out.println(potion.getName());
        }
        int amountOfPotionsToRemove = View.getInstance().askUserWhatAmountOfPotionsToRemove();
        for (int i = 0; i < amountOfPotionsToRemove ; i++) {
            boolean exists = false;
            while (!exists){
                String potionToRemove = View.getInstance().askUserWhatPotionToRemove();
                for (Potion potion : potions) {
                    if (potionToRemove.equalsIgnoreCase(potion.getName())) {
                        potions.remove(potion);
                        System.out.println("The following potion has been removed: " + potionToRemove);
                        exists = true;
                        break; //TODO: THIS CODE LOOKS HORRIBLE - How to improve it?
                    }
                }
                if (!exists){
                    System.out.println("The potion you entered doesn't exist.");
                }
            }
        }
    } //TODO: INTE SÅ SNYGGT

}
