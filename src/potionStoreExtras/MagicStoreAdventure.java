package potionStoreExtras;

import com.company.View;

public class MagicStoreAdventure {

    private String userChoice;
    private boolean isCorrectInput = false;
    private StoryText storyText = new StoryText();

    //METHODS

    //BEGINNING THE STORY
    public void startAdventure() {
        storyText.startAdventure();
        System.out.println("Do you 1) enter, or do you 2) walk away?");
        while (!isCorrectInput) {
            userChoice = View.getInstance().getUserDecision();
            if ((userChoice.equalsIgnoreCase("1")) || (userChoice.equalsIgnoreCase("enter"))) {
                enterStore();
                isCorrectInput = true;
            } else if ((userChoice.equalsIgnoreCase("2")) || (userChoice.equalsIgnoreCase("walk away"))) {
                doNotEnterStore();
                isCorrectInput = true;
            } else {
                System.out.println("Incorrect input. Try pressing 1 or 2.");
            }
        }
    }

    private void enterStore() {
        storyText.enterStore();
        System.out.println("Do you choose to talk to the 1) young boy or 2) older woman?");
        while (!isCorrectInput) {
            userChoice = View.getInstance().getUserDecision();
            if ((userChoice.equalsIgnoreCase("1")) || (userChoice.equalsIgnoreCase("young boy"))) {
                youngBoy();
                isCorrectInput = true;
            } else if ((userChoice.equalsIgnoreCase("2")) || (userChoice.equalsIgnoreCase("older woman"))) {
                olderWoman();
                isCorrectInput = true;
            } else {
                System.out.println("Incorrect input. Try pressing 1 or 2.");
            }
        }
    }

    private void doNotEnterStore() {
        storyText.doNotEnterStore();
    }


    //PATH YOUNG BOY
    private void youngBoy(){
        storyText.youngBoy();
        System.out.println("Do you ask to see the 1) Alchemy corner, 2) Antique collection, 3) Book section or 4) Gallery?");
        while (!isCorrectInput) {
            userChoice = View.getInstance().getUserDecision();
            if ((userChoice.equalsIgnoreCase("1")) || (userChoice.equalsIgnoreCase("alchemy corner"))) {
                youngBoyAlchemyCorner();
                isCorrectInput = true;
            } else if ((userChoice.equalsIgnoreCase("2")) || (userChoice.equalsIgnoreCase("antique collection"))) {
                youngBoyAntiqueCollection();
                isCorrectInput = true;
            } else if ((userChoice.equalsIgnoreCase("3")) || (userChoice.equalsIgnoreCase("book section"))) {
                youngBoyBookSection();
                isCorrectInput = true;
            } else if ((userChoice.equalsIgnoreCase("4")) || (userChoice.equalsIgnoreCase("gallery"))) {
                youngBoyGallery();
                isCorrectInput = true;
            } else {
                System.out.println("Incorrect input. Try pressing 1, 2, 3, or 4.");
            }
        }
    }

    private void youngBoyAlchemyCorner(){
        storyText.youngBoyAlchemyCorner();
        System.out.println("Do you ask about the Potion of 1) Success, or the Potion of 2) Rain?");
        System.out.println("Or do you want to move further to the 3) Antique collection, 4) Book section or 5) Gallery?");
        while (!isCorrectInput) {
            userChoice = View.getInstance().getUserDecision();
            if ((userChoice.equalsIgnoreCase("1")) || (userChoice.equalsIgnoreCase("success"))) {
                youngBoyPotionOfSuccess();
                isCorrectInput = true;
            } else if ((userChoice.equalsIgnoreCase("2")) || (userChoice.equalsIgnoreCase("rain"))) {
                youngBoyPotionOfRain();
                isCorrectInput = true;
            } else if ((userChoice.equalsIgnoreCase("3")) || (userChoice.equalsIgnoreCase("antique collection"))) {
                youngBoyAntiqueCollection();
                isCorrectInput = true;
            } else if ((userChoice.equalsIgnoreCase("4")) || (userChoice.equalsIgnoreCase("book section"))) {
                youngBoyBookSection();
                isCorrectInput = true;
            } else if ((userChoice.equalsIgnoreCase("5")) || (userChoice.equalsIgnoreCase("gallery"))) {
                youngBoyGallery();
                isCorrectInput = true;
            } else {
                System.out.println("Incorrect input. Try pressing 1, 2, 3, 4, or 5.");
            }
        }
    }

    private void youngBoyPotionOfSuccess(){
        storyText.youngBoyPotionOfSuccess();
        System.out.println("Do you 1) buy the potion, or return to the 2) Alchemy corner?");
        while (!isCorrectInput) {
            userChoice = View.getInstance().getUserDecision();
            if ((userChoice.equalsIgnoreCase("1")) || (userChoice.equalsIgnoreCase("buy the potion"))) {
                youngBoyPotionOfSuccessBuy();
                isCorrectInput = true;
            } else if ((userChoice.equalsIgnoreCase("2")) || (userChoice.equalsIgnoreCase("alchemy corner"))) {
                youngBoyAlchemyCorner();
                isCorrectInput = true;
            } else {
                System.out.println("Incorrect input. Try pressing 1 or 2.");
            }
        }
    }

    private void youngBoyPotionOfSuccessBuy() {
        storyText.youngBoyPotionOfSuccessBuy();
    }

    private void youngBoyPotionOfRain(){
        storyText.youngBoyPotionOfRain();
        System.out.println("Do you 1) buy the potion, or return to the 2) Alchemy corner?");
        while (!isCorrectInput) {
            userChoice = View.getInstance().getUserDecision();
            if ((userChoice.equalsIgnoreCase("1")) || (userChoice.equalsIgnoreCase("buy the potion"))) {
                youngBoyPotionOfRainBuy();
                isCorrectInput = true;
            } else if ((userChoice.equalsIgnoreCase("2")) || (userChoice.equalsIgnoreCase("alchemy corner"))) {
                youngBoyAlchemyCorner();
                isCorrectInput = true;
            } else {
                System.out.println("Incorrect input. Try pressing 1 or 2.");
            }
        }
    }

    private void youngBoyPotionOfRainBuy(){
        storyText.youngBoyPotionOfRainBuy();
    }

    private void youngBoyAntiqueCollection(){
        underConstructionMessage();
    } //TODO

    private void youngBoyBookSection(){
        underConstructionMessage();
    } //TODO

    private void youngBoyGallery(){
        underConstructionMessage();
    } //TODO

    //PATH OLDER WOMAN
    private void olderWoman(){
        System.out.println("To be continued.");
    } //TODO
    private void olderWomanAlchemyCorner(){
        System.out.println("To be continued.");
    } //TODO
    private void olderWomanAntiqueCollection(){
        System.out.println("To be continued.");
    } //TODO
    private void olderWomanBookSection(){
        System.out.println("To be continued.");
    } //TODO
    private void olderWomanGallery(){
        System.out.println("To be continued.");
    } //TODO

    private void underConstructionMessage(){
        System.out.println("This part of the story is still under construction, click 1) return to continue the story with another choice.");
        while (!isCorrectInput) {
            userChoice = View.getInstance().getUserDecision();
            if ((userChoice.equalsIgnoreCase("1")) || (userChoice.equalsIgnoreCase("return"))) {
                youngBoy();
            }
        }
    }

}

