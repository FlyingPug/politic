package com.vaflya.politic.service;

import com.vaflya.politic.dto.QuizDto;
import org.json.JSONObject;

public interface QuizService
{
    /*
        возвращает все вопросы и ответы
     */
    QuizDto getQuestions();

    /*
       Получает полит. Идеологию на основании ответов
    */
    String getIdeology(int[] answers);
}

