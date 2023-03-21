package com.vaflya.politic.service;

import org.json.JSONObject;

public interface QuizService
{
    /*
        возвращает все вопросы и ответы
     */
    JSONObject getQuestions();

    /*
       получает полит. идеологию на основании ответов
    */
    String getIdeology(int[] answers);
}

