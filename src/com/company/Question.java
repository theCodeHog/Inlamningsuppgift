package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Question implements Serializable {

    private String question;
    private String[] answers = new String[4];

    Question(String question, String answer0, String answer1, String answer2, String answer3){
        this.question = question;
        answers[0] = answer0;
        answers[1] = answer1;
        answers[2] = answer2;
        answers[3] = answer3;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }
}
