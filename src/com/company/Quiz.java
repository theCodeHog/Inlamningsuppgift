package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Arrays;

public class Quiz {

    //FIELDS
    private Question[] questions;
    private int[] userResults = new int[8];

    //CONSTRUCTOR
    public Quiz(){

        }

    //METHODS

    public void runWhatScrollIsBestForYouQuiz(){
        loadScrollQuizQuestions();
        int userQuestionResult = 0;

        for (Question question : questions) {
            System.out.println("\n" + question.getQuestion());
            System.out.println(Arrays.toString(question.getAnswers()).replace("["," ").replace("]","").replace(",","\n"));
            System.out.println("(Choose from 1-4 and press enter)");
            int userChoice = View.getInstance().askUserToEnterInteger();
            userResults[userQuestionResult] = userChoice;
            userQuestionResult++;
        }

        int result = calculateResults();
        scrollQuizResults(result);
    }

    private void loadScrollQuizQuestions() {

        Question question1 = new Question("How do you feel about unpredictable situations?",
                "1. I absolutely love them. They energize me and make me feel alive!",
                "2. I am not sure. It depends.",
                "3. I am neutral. They don’t make me feel uncomfortable but at times I get annoyed by unexpected surprises.",
                "4. It makes me feel very uncomfortable. I love routines and enjoy planning everything ahead.");

        Question question2 = new Question("Are you spontaneous?",
                "1. Yes! I enjoy doing things at the spur of the moment!",
                "2. I wouldn’t describe myself as spontaneous. I am an emotional person which means I change my mind often.",
                "3. I am not spontaneous but I can take a fast decision when I have to.",
                "4. I am not spontaneous at all. I enjoy careful planning and preparation.");

        Question question3 = new Question("Do you get bored easily?",
                "1. Yes - I get bored very fast. I can’t take routine and familiarity for very long. If I don't get to see new places and get to know people and do new things I will go insane.",
                "2. No. Not really. I tend to get attached to people and places. This keeps me from getting bored.",
                "3. No. I always do something interesting. I don’t depend on other people or circumstances to make me feel happy. I have my own goals and plans – there is no place for boredom in my life.",
                "4. I never experience boredom. I can easily stay in a remote place with no entertainment without getting bored.");

        Question question4 = new Question("What are you interested in?",
                "1. I have a wide range of interests. However - I don’t get deeply involved in any given subject.",
                "2. I am really into communication and relationships. I am interested in people around me.",
                "3. I have many interests but it’s hard for me to concentrate on many different subjects at once. I tend to study one subject in detail and then move on to the next one.",
                "4. I can’t say I have many interests but I am an educated person.");

        Question question5 = new Question("How emotional are you?",
                "1. I am emotional... but I'm not too sensitive to other people’s feelings.",
                "2. I am very emotional and very sensitive.",
                "3. I remain calm on the outside - even when I’m upset. In general I tend to hide my feelings and I am proud of my ability to solve problems without emotions getting in the way.",
                "4. I am not emotional.");

        Question question6 = new Question("What's your energy level?",
                "1. Extremely high.",
                "2. It depends on my mood and what’s going on in my life.",
                "3. My energy levels are steady. If I feel down I can force myself to carry on as normal.",
                "4. Energy level? What do you mean?");

        Question question7 = new Question("What's your ideal weekend like?",
                "1. Do something new like traveling.",
                "2. Have a quality time with my partner. If I am single I will read romantic books or watch romantic movies.",
                "3. Take an advantage of this extra time to learn new things or acquire new skills that will help me achieve my goals.",
                "4. I really enjoy spending time with family and friends.");

        Question question8 = new Question("How do you spend your money?",
                "1. I love luxury and special experiences. I tend to spend a lot.",
                "2. I enjoy buying gifts for people I love.",
                "3. I am good at money management. However I don’t mind spending for things that have a real value.",
                "4. I always plan my spending and at times tend to be a little stingy.");

        questions = new Question[]{question1, question2, question3, question4, question5, question6, question7, question8};
    }

    private int calculateResults(){
        int amountOf1 = 0;
        int amountOf2 = 0;
        int amountOf3 = 0;
        int amountOf4 = 0;

        for (int userResult : userResults) {
            if (userResult == 1) {
                amountOf1++;
            } else if (userResult == 2) {
                amountOf2++;
            } else if (userResult == 3) {
                amountOf3++;
            } else {
                amountOf4++;
            }
        }

        if (amountOf1 > amountOf2 && amountOf1 > amountOf3 && amountOf1 > amountOf4){
            return 1;
        } else if (amountOf2 > amountOf1 && amountOf2 > amountOf3 && amountOf2 > amountOf4){
            return 2;
        } else if (amountOf3 > amountOf1 && amountOf3 > amountOf2 && amountOf3 > amountOf4){
            return 3;
        } else {
            return 4;
        }
    }

    private void scrollQuizResults(int result){
        System.out.println("-------------------------------------- RESULT --------------------------------------");
        if (result == 1){
            System.out.println("You tend to be lively, optimistic, buoyant, and carefree. You love adventure and have\n" +
                    "high risk tolerance. You are typically poor at tolerating boredom and will seek variety and\n" +
                    "entertainment. Because you are prone to pleasure-seeking behaviors, you are likely to struggle\n" +
                    "with addictions. You constant craving can lead to overeating and weight problems.\n\n" +
                    "You are very creative and can become a great artist. Moreover, you are likely a fantastic\n" +
                    "entertainer and will do well if you choose a career in the entertainment industry.\n");
            System.out.println("You should buy the scroll of Discipline. Obviously.\n");
        } else if (result == 2){
            System.out.println("You are probably a people person. You seek interpersonal harmony and close\n" +
                    "relationships, which makes you a loyal spouse and a loving parent. You make it a point to\n" +
                    "preserve your relationships with old friends, distant family members, and neighbors. You\n" +
                    "tend to avoid conflict and always try to mediate between others to restore peace and harmony.\n");
            System.out.println("You should buy the scroll of Self Confidence and learn to believe in your abilities already!\n");
        } else if (result == 3){
            System.out.println("You are probably a goal-oriented person. You are very savvy, analytical, and logical.\n" +
                    "Extremely practical and straightforward, you aren’t necessarily a good companion or particularly\n" +
                    "friendly. You dislike small talk, but enjoy deep and meaningful conversations instead.\n" +
                    "You would rather be alone than in the company of shallow, superficial people.\n" +
                    "Ideally, you want to spend your precious time with people who have similar professional interests.\n");
            System.out.println("You should buy the scroll of Relaxation OR Compassion. Seriously, ease up. \n");
        }else if (result == 4){
            System.out.println("You are likely very traditional! You love your family and friends and probably don't\n" +
                    "look for novelty and adventure. Even more so, I expect you avoid it as much as you can. You are\n" +
                    "unlikely to marry a foreigner or leave your homeland for another country. None the less, you are\n" +
                    "very social and seek to contribute to the community around you. Being extremely thorough and\n" +
                    "accurate, you make an excellent manager!");
            System.out.println("You should buy the scroll of Spontaneity. Stop overthinking and start doing!\n");
        }
    }
}
