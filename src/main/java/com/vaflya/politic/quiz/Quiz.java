package com.vaflya.politic.quiz;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Quiz {
    private String name;
    private Weight[] weights;
    private Question[] questions;

    static final public String saveDir = "src/main/resources/";

    public Quiz(String name, Weight[] weights, Question[] questions) {
        this.name = name;
        this.weights = weights;
        this.questions = questions;
    }

    public Quiz() {
        // initialize default values if necessary
    }

    public static Quiz load(String quizName)
    {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(saveDir + quizName +  ".json"), Quiz.class);
        }
        catch (Exception ex)
        {
            System.out.println("fucl");
           throw new RuntimeException(ex);
        }
    }

    public void save() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File(saveDir + name +  ".json");
            mapper.writeValue(file, this);
        } catch (Exception ex)
        {
            System.err.println(ex);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weight[] getWeights() {
        return weights;
    }

    public void setWeights(Weight[] weights) {
        this.weights = weights;
    }

    public Question[] getQuestions() {
        return questions;
    }

    public void setQuestions(Question[] questions) {
        this.questions = questions;
    }
}
