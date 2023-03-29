package com.vaflya.politic.service;

import java.util.HashMap;
import java.util.Map;

import com.vaflya.politic.dto.QuestionDto;
import com.vaflya.politic.dto.QuizDto;
import com.vaflya.politic.quiz.Quiz;
import com.vaflya.politic.quiz.Weight;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImplementation implements QuizService {

    Quiz politicQuiz;

    public QuizServiceImplementation() {
        this.politicQuiz =  Quiz.load("politicQuiz");
    }

    public QuizDto getQuestions()
    {
        QuestionDto[] questions = new QuestionDto[politicQuiz.getQuestions().length];
        for(int i = 0;i < politicQuiz.getQuestions().length;i++)
        {
            String[] answers = new String[politicQuiz.getQuestions()[i].getAnswers().length];
            for(int j = 0;j < politicQuiz.getQuestions()[i].getAnswers().length;j++)
            {
                answers[j] = politicQuiz.getQuestions()[i].getAnswers()[j].getAnswer();
            }
            questions[i] = new QuestionDto(politicQuiz.getQuestions()[i].getQuestion(), answers);
        }
        return new QuizDto(politicQuiz.getName(), questions);
    }

     public String getIdeology(int[] answers)
     {
         // бтв, по логике тут хорошо бы заменить ideologyMND и ideologyMMD на что-то общее, но если правильно так...
         Map<String, Double> ideologyMMD = new HashMap<>(); // меры доверия
         Map<String, Double> ideologyMND = new HashMap<>(); // меры недоверия
         for(Weight weight : politicQuiz.getWeights())
         {
            ideologyMMD.put(weight.getLabel(), weight.getValue());
            ideologyMND.put(weight.getLabel(), weight.getValue());
         }
         int questionCount = politicQuiz.getQuestions().length;
         // TODO: Написать нормальные экспешены
         if(answers.length != questionCount) throw new RuntimeException("wrong input");
         for(int i = 0;i < answers.length;i++)
         {
             if(answers[i] >= politicQuiz.getQuestions()[i].getAnswers().length) throw new RuntimeException("wrong inexes");
             for(Weight weight : politicQuiz.getQuestions()[i].getAnswers()[answers[i]].getWeights())
             {
                 if(!ideologyMMD.containsKey(weight.getLabel())) throw new RuntimeException("there is no such var as " + weight.getLabel());
                 if(weight.getValue() > 0) {
                     double MD = ideologyMMD.get(weight.getLabel());
                     double mod = MD + weight.getValue() * (1 - MD);
                     ideologyMMD.put(weight.getLabel(), mod);
                 }
                 else
                 {
                     double ND = -ideologyMND.get(weight.getLabel());
                     double mod = ND + weight.getValue() * (1 - ND);
                     ideologyMND.put(weight.getLabel(), mod);
                 }
             }
         }

         Map.Entry<String, Double> maxEntry = null;
         for (Map.Entry<String, Double> entry : ideologyMMD.entrySet())
         {
             double KD =  ideologyMMD.get(entry.getKey()) - ideologyMND.get(entry.getKey());
             if(maxEntry == null || KD > maxEntry.getValue())
             {
                 maxEntry = entry;
                 maxEntry.setValue(KD);
             }
         }

         assert maxEntry != null;
         return maxEntry.getKey();
     }
}
