package com.example.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Question;
import com.example.model.User;
import com.example.service.QuestionService;
import com.example.service.UserService;

@RestController
@RequestMapping("/api")
public class controller 
{
	
    @Autowired
    private UserService userService;

    @Autowired
    private QuestionService questionService;
//    @GetMapping("/getUsers/{id}")
//    public String getUserDetails(@PathVariable Long id)
//    {
//    	Optional<User> getuserById = userService.getuserById(id);
//    	if(getuserById.get().getIsSubscribe().equalsIgnoreCase("true"))
//    	{
//    		return "subscribe"; 
//    	}
//    	else
//    	{
//    		return "not subscribe";
//    	}
//    }
    
    @GetMapping("/getUsers/{id}")
    public ResponseEntity<String> getUserDetails(@PathVariable Long id) {
        Optional<User> userOptional = userService.getuserById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getIsSubscribe().equalsIgnoreCase("true")) {
                return ResponseEntity.ok("subscribe");
            } else {
                // User is not subscribed, proceed to show questions
                return showQuestionsToUser(id);
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private ResponseEntity<String> showQuestionsToUser(Long userId) {
        List<Question> questions = questionService.getFourRandomQuestions();
        if (questions.isEmpty()) {
            return ResponseEntity.ok("No questions available");
        }

        for (Question question : questions) {
            
            userAnswerService.storeUserAnswer(userId, question.getId(), userAnswer);
        }

        String result = calculateResult(userId);

        return ResponseEntity.ok(result);
    }

    private String calculateResult(Long userId) 
    {
        List<UserAnswer> userAnswers = userAnswerService.getUserAnswersByUserId(userId);

        return "Your result is: ...";
    }
}