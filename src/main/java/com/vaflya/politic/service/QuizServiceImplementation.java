package com.vaflya.politic.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImplementation implements QuizService {
    public JSONObject getQuestions()
    {
        try {
            String content = new String(Files.readAllBytes(Paths.get("static/json/questions.json")));
            return new JSONObject(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

     public String getIdeology(int[] answers)
    {
        try {
            String content = new String(Files.readAllBytes(Paths.get("static/json/questions.json")));
        }
        catch (IOException e) {
            System.err.println("Файл с вопросами не был найден"); // TODO: добавить логирование
            throw new RuntimeException(e);
        }
        return "shit";
    }
}
