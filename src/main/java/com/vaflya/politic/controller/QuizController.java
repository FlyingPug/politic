package com.vaflya.politic.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaflya.politic.dto.PoliticAnswer;
import com.vaflya.politic.dto.QuizDto;
import com.vaflya.politic.service.QuizService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

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

    @PostMapping(value = "answer")
    public ResponseEntity<PoliticAnswer> getAnswer(@RequestBody int[] answers)
    {
        return ResponseEntity.ok(new PoliticAnswer("dfs","fsd"));
    }
}
