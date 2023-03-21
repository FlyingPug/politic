package com.vaflya.politic.quiz;

public class Question {
    public String question;
    public Answer[] answers;

    public Question(String question, Answer... answers) {
        this.question = question;
        this.answers = answers;
    }
}
