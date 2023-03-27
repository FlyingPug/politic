package com.vaflya.politic.dto;

public class QuizDto {
    private String quizName;
    private QuestionDto[] questions;

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public QuestionDto[] getQuestions() {
        return questions;
    }

    public void setQuestions(QuestionDto[] questions) {
        this.questions = questions;
    }

    public QuizDto(String quizName, QuestionDto[] questions) {
        this.quizName = quizName;
        this.questions = questions;
    }

    public QuizDto(QuestionDto[] questions) {
        this.questions = questions;
        this.quizName = "defaultQuiz";
    }
}
