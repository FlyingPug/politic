package com.vaflya.politic.quiz;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.StringWriter;

public class Quiz {
    public String name;
    public Weight[] weights;
    public Question[] questions;

    public Quiz(String name, Weight[] weights, Question[] questions) {
        this.name = name;
        this.weights = weights;
        this.questions = questions;
    }

    public void save() {
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(writer, this);
        } catch (Exception ex)
        {
            System.err.println(ex);
        }
    }

}
