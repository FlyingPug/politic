package com.vaflya.politic.service;

import com.vaflya.politic.dto.QuestionAndAnswers;

public interface QuizService
{
    /*
        возвращает все вопросы и ответы
     */
    QuestionAndAnswers[] getQuestions();
}

