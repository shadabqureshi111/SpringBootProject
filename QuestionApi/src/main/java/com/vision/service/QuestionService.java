package com.vision.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vision.model.QuestionModel;
import com.vision.repository.QuestionRepository;

@Service
public class QuestionService {
	
	private final static String uri="https://jservice.io/api/random?count=5";
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private QuestionRepository qrepo;
	
	@PostConstruct
	public void loadData() {
		
		ResponseEntity<QuestionModel[]> response = template.getForEntity(uri, QuestionModel[].class );
		
		if(response.getStatusCode()==HttpStatus.OK) {
			QuestionModel[] body = response.getBody();
			List<QuestionModel> objs = Arrays.asList(body);
			 qrepo.saveAllAndFlush(objs);
		}
		
	}

	public ResponseEntity<?> getQuetions() {
		try {
		List<Map<String, Object>> res = qrepo.findIdAndQuestion();
		System.out.println(res.get(0));
		return new ResponseEntity(res, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		
	}

	public ResponseEntity<?> getNextQuetion(Integer id) {
		try {
		List<Map<String, Object>> ques = qrepo.findNextQuetion(id);
		Map<String,Object> res=new HashMap<String, Object>();
		for(Map<String, Object> m:ques) {
			System.out.println(m.get("id").toString());
			if(m.get("id").toString().equals(id.toString()))
				res.put("correct_answer", m.get("ans"));
			else
				res.put("next_question",Map.of("question_id", m.get("id"), "question", m.get("question")));
		}
		return ResponseEntity.ok(res);
		}catch (Exception e) {
			return new ResponseEntity(e.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
