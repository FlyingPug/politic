package com.vaflya.politic.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.vaflya.politic.dto.QuestionDto;
import com.vaflya.politic.dto.QuizDto;
import com.vaflya.politic.quiz.Quiz;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImplementation implements QuizService {

    Quiz politicQuiz;

    public QuizServiceImplementation() {
        this.politicQuiz =  Quiz.load("politicQuiz");
    }

    public QuizDto getQuestions()
    {
        QuestionDto[] questions = new QuestionDto[politicQuiz.questions.length];
        for(int i = 0;i < politicQuiz.questions.length;i++)
        {
            String[] answers = new String[politicQuiz.questions[i].answers.length];
            for(int j = 0;j < politicQuiz.questions[i].answers.length;j++)
            {
                answers[j] = politicQuiz.questions[i].answers[j].answer;
            }
            questions[i] = new QuestionDto(politicQuiz.questions[i].question, answers);
        }
        return new QuizDto(politicQuiz.name, questions);
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
