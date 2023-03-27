package com.vaflya.politic.dto;

public class AnswerOnQuestionDto {
    private int[] answers;

    public int[] getAnswers() {
        return answers;
    }

    public void setAnswers(int[] answers) {
        this.answers = answers;
    }

    public AnswerOnQuestionDto(int[] answers) {
        this.answers = answers;
    }

    public AnswerOnQuestionDto() {}
}
