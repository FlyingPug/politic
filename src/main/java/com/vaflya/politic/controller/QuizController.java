package com.vaflya.politic.controller;

import com.vaflya.politic.dto.QuestionAndAnswers;
import com.vaflya.politic.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "quiz")
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("")
    public String getQuizPage() {
        return "politicQuiz.html";
    }

    @GetMapping("questions")
    public @ResponseBody ResponseEntity<QuestionAndAnswers[]> getQuestions()
    {

    }
}
