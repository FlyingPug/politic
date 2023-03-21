package com.vaflya.politic.dto;

public class QuestionAndAnswers {
    private String question;

    private String[] answers;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public QuestionAndAnswers(String question, String[] answers) {
        this.question = question;
        this.answers = answers;
    }
}
