package com.vaflya.politic.quiz;

public class Answer {
    private String answer;
    private Weight[] weights;

    public Answer(String text, Weight... weights) {
        this.answer = text;
        this.weights = weights;
    }

    public Answer() {}


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Weight[] getWeights() {
        return weights;
    }

    public void setWeights(Weight[] weights) {
        this.weights = weights;
    }
}
