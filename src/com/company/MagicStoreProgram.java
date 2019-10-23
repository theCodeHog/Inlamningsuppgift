package com.company;

import potionStoreExtras.MagicStoreAdventure;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Paola Tosca van den Bor
 */

public class MagicStoreProgram {

    //FIELDS
    ArrayList<Potion> potions;
    ArrayList<Scroll> scrolls;

    //CONSTRUCTOR
    public MagicStoreProgram(){
        if (Files.exists(Paths.get("potions.ser"))) {
            potions = new ArrayList<Potion>(FileUtils.readObjects("potions.ser"));
            System.out.println("Starting the program with your latest list of Potions.\n");
        } else {
            potions = new ArrayList<>();
            ArrayList<String> standardPotions = (ArrayList<String>) FileUtils.readAllLines ("listOfStandardPotions.txt");
            for (String standardPotion : standardPotions) {
                String temp[] = standardPotion.split(";");
                potions.add(new Potion(temp[0], temp[1], Double.parseDouble(temp[2])));
            }
            System.out.println("Starting the program with 10 standard potions in your list.\n");
        }
    }

    //METHODS ----------------------------------------------------------------

    //MAIN MENU METHODS
    public void startProgram() {

        System.out.println("Welcome to the Magic Store!" +
                "\nCurrently selling potions and scrolls.\n");

        boolean isRunning = true;
        while (isRunning) {

            switch (View.getInstance().showMainMenuAndGetChoice()){
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
        MagicStoreAdventure magicStoreAdventure = new MagicStoreAdventure();
        magicStoreAdventure.startAdventure();
    } //TODO: WIP

    public void whatScrollShouldYouBuyQuiz(){
        System.out.println("Under construction!");

    } //TODO

    public void loadQuizQuestions(){
        //https://psychologia.co/four-temperaments-test/

        Question question1 = new Question("How do you feel about unpredictable situations?",
                "I absolutely love them. They energize me and make me feel alive!",
                "I am not sure. It depends.",
                "I am neutral. They don’t make me feel uncomfortable but at times I get annoyed by unexpected surprises.",
                "It makes me feel very uncomfortable. I love routines and enjoy planning everything ahead.");

        Question question2 = new Question("Are you spontaneous?",
                "Yes! I enjoy doing things at the spur of the moment!",
                "I wouldn’t describe myself as spontaneous. I am an emotional person which means I change my mind often.",
                "I am not spontaneous but I can take a fast decision when I have to.",
                "I am not spontaneous at all. I enjoy careful planning and preparation.");

        Question question3 = new Question("Do you get bored easily?",
                "Yes, I get bored very fast. I can’t take routine and familiarity for very long. I need to see new places, get to know people and do new things or I will go insane.",
                "No, not really. I tend to get attached to people and places. This keeps me from getting bored.",
                "No, I always do something interesting. I don’t depend on other people or circumstances to make me feel happy. I have my own goals and plans – there is no place for boredom in my life.",
                "I never experience boredom. I can easily stay in a remote place with no entertainment without getting bored.");

        Question question4 = new Question("What are you interested in?",
                "I have a wide range of interests. However, I don’t get deeply involved in any given subject.",
                "I am really into communication and relationships. I am interested in people around me.",
                "I have many interests but it’s hard for me to concentrate on many different subjects at once. I tend to study one subject in detail and then move on to the next one. I am especially interested in technology. I like to figure out things and understand how everything works.",
                "I can’t say I have many interests but I am an educated person.");

        Question question5 = new Question("How emotional are you?",
                "I am emotional, but I'm not too sensitive to other people’s feelings.",
                "I am very emotional and very sensitive.",
                "I remain calm on the outside, even when I’m upset. In general I tend to hide my feelings and I am proud of my ability to solve problems without emotions getting in the way.",
                "I am not emotional.");

        Question question6 = new Question("What's your energy level?",
                "Extremely high.",
                "It depends on my mood and what’s going on in my life.",
                "My energy levels are steady. If I feel down I can force myself to carry on as normal.",
                "Energy level? What do you mean?");

        Question question7 = new Question("What's your ideal weekend like?",
                "Do something new like traveling.",
                "Have a quality time with my partner. If I am single I will read romantic books or watch romantic movies.",
                "Take an advantage of this extra time to learn new things or acquire new skills that will help me achieve my goals.",
                "I really enjoy spending time with family and friends.");

        Question question8 = new Question("How do you spend your money?",
                "I love luxury and special experiences. I tend to spend a lot.",
                "I enjoy buying gifts for people I love.",
                "I am good at money management. However I don’t mind spending for things that have a real value.",
                "I always plan my spending and at times tend to be a little stingy.");

    }

    public void showAllScrolls(){
        //if scrolls = empty do this....
        scrolls = new ArrayList<>();
        ArrayList<String> standardScrolls = (ArrayList<String>) FileUtils.readAllLines ("scrolls.txt");
        for (String scroll : standardScrolls) {
            String[] temp = scroll.split(";");
            scrolls.add(new Scroll(temp[0], temp[1], Double.parseDouble(temp[2])));
        }
        System.out.println(scrolls.toString().replace("[","").replace("]","").replace(",","-"));
        //else just print the scrolls arrayList.
    } //TODO: Add try catch here in case the file can't be found and add the else-if sats.


    //SUBMENU METHODS
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
                        break; //TODO: THIS CODE LOOKS BAD - How to improve it?
                    }
                }
                if (!exists){
                    System.out.println("The potion you entered doesn't exist.");
                }
            }
        }
    } //TODO: INTE SÅ SNYGGT

}
