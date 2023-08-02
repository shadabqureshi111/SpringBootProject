package com.example.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.model.Question;
import com.example.model.UserAnswer;
import com.example.repository.QuestionRepository;
import com.example.repository.UserAnswerRepo;

@Service
public class QuestionService {

    @Autowired
    private RestTemplate template;

    @Autowired
    private QuestionRepository qrepo;

    @Autowired
	private UserAnswerRepo userAnswerRepo;
    private Map<Integer, Integer> AnswerQuestion = new HashMap<>();


    public ResponseEntity<?> saveUserAnswer(Integer userId, String answer) {
        Integer ansQue = AnswerQuestion.getOrDefault(userId, 1);
        
        System.out.println("ansQue = "+ansQue);
        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setUid(userId);
        userAnswer.setAnswer(answer);
        userAnswer.setQuestion(qrepo.getById(ansQue));
        userAnswerRepo.save(userAnswer);

        Integer nextQuestionId = ansQue + 1;

        AnswerQuestion.put(userId, nextQuestionId);

        return getNextQuetion(nextQuestionId);
    }

    public ResponseEntity<?> getNextQuetion(Integer questionId) {
        Optional<Question> nextQuestion = qrepo.findById(questionId);
        if (nextQuestion.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Question not found");
        }

        Question nextQ = nextQuestion.get();
        Map<String, Object> res = new HashMap<>();
        //res.put("question_id", nextQuestion.getId());
        res.put("question", nextQ.getQuestion());

        return ResponseEntity.ok(res);
    }

    
    
    
    
    public ResponseEntity<?> getQuestions() {
        List<Map<String, Object>> res = qrepo.findIdAndQuestion();
        return ResponseEntity.ok(res);
    }
}
