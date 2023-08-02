package com.vision.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vision.service.QuestionService;


@RestController
public class Controller {
	
	@Autowired
	private QuestionService apiSer;
	
	@GetMapping("/play")
	public ResponseEntity<?> getQuestion(){
		
		return apiSer.getQuetions();
	}
	
	@PostMapping("/next")
	public ResponseEntity<?> nextQuestion(@RequestBody Map<String,Object> req)
	{
		Integer id=(Integer) req.get("question_id");
		return apiSer.getNextQuetion(id);
	}

}
