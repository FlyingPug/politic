package com.vaflya.politic.quiz;

public class Answer {
    public String answer;
    public Weight[] weights;

    public Answer(String text, Weight... weights) {
        this.answer = text;
        this.weights = weights;
    }
}
