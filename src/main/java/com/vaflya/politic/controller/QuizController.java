package com.vaflya.politic.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaflya.politic.dto.PoliticAnswer;
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
    public @ResponseBody Object getQuestions()
    {
        Resource resource = new ClassPathResource("/static/json/questions.json");
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(resource.getInputStream(), Object.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping(value = "answer")
    public ResponseEntity<PoliticAnswer> getAnswer(@RequestBody int[] answers)
    {
        return ResponseEntity.ok(new PoliticAnswer("dfs","fsd"));
    }
}
