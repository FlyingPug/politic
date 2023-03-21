package com.vaflya.politic.service;

import com.vaflya.politic.dto.QuestionAndAnswers;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

public class QuizServiceImplementation
{
    JSONObject  getQuestions()
    {
        try {
            String content = new String(Files.readAllBytes(Paths.get("questions.json")));
            JSONObject jsonObject = new JSONObject(content);
            JSONArray questions = jsonObject.getJSONArray("questions");

    }
}
