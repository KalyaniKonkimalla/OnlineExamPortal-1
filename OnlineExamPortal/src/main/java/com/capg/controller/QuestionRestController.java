package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.exception.QuestionNotFoundException;
import com.capg.model.Question;
import com.capg.service.QuestionService;

@RestController
public class QuestionRestController {
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/question")
	public ResponseEntity<List<Question>> getQuestions(){
		return questionService.getQuestions();
	}
	@GetMapping("/question/{id}")
	public ResponseEntity<Question> getQuestionById(@PathVariable(value = "id") int q_id) throws QuestionNotFoundException
	{
		return questionService.getQuestionById(q_id);
	}
	
	@PutMapping("/question/{id}")
	public ResponseEntity<Question> updateQuestionById(@PathVariable(value = "id") int q_id, @RequestBody Question question) throws QuestionNotFoundException
	{
		return questionService.updateQuestionById(q_id, question);
	}
	
	@DeleteMapping("/question/{id}")
	public ResponseEntity<Question> deleteQuestionById(@PathVariable(value = "id")int q_id) throws QuestionNotFoundException
	{
		return questionService.deleteQuestionById(q_id);
	}

}
