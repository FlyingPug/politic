package com.vaflya.politic.controller;

import com.vaflya.politic.dto.AnswerOnQuestionDto;
import com.vaflya.politic.dto.PoliticAnswerDto;
import com.vaflya.politic.dto.QuizDto;
import com.vaflya.politic.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(value = "questions", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<QuizDto> getQuestions()
    {
        QuizDto quiz = quizService.getQuestions();
        return ResponseEntity.ok(quiz);
    }

    @PostMapping(value = "answers", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PoliticAnswerDto> getAnswer(@RequestBody AnswerOnQuestionDto answerDto)
    {
        String ideology = quizService.getIdeology(answerDto.getAnswers());
        return ResponseEntity.ok(new PoliticAnswerDto(ideology,"/pictures/" + ideology + ".jpg"));
    }
}
