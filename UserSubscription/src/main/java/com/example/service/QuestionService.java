package com.example.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Question;
import com.example.repository.QuestionRepository;

@Service
public class QuestionService 
{

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getFourRandomQuestions() 
    {
        List<Question> allQuestions = questionRepository.findAll();

        Collections.shuffle(allQuestions);

        return allQuestions.stream().limit(4).collect(Collectors.toList());
    }

    // Add more methods as needed for question-related operations
}
