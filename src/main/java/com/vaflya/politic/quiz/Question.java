package com.vaflya.politic.quiz;

public class Question {
    private String question;
    private Answer[] answers;

    public Question(String question, Answer... answers) {
        this.question = question;
        this.answers = answers;
    }

    public Question()
    {

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer[] getAnswers() {
        return answers;
    }

    public void setAnswers(Answer[] answers) {
        this.answers = answers;
    }
}
