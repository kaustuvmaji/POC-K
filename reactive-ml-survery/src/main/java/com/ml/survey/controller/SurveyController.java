package com.ml.survey.controller;

import java.math.BigInteger;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ml.survey.common.LogMethodExecution;
import com.ml.survey.service.SurveyService;
import com.ml.survey.vo.AnswerVO;
import com.ml.survey.vo.QuestionAnswerVO;
import com.ml.survey.vo.QuestionVO;
import com.ml.survey.vo.SurveyVO;



@RestController
@RequestMapping("/survey")
@Validated
public class SurveyController {
	
	@Autowired
	SurveyService surveyService;
	
	@GetMapping("/questions")
	@LogMethodExecution
	public List<QuestionAnswerVO> findQuestions() {
		return surveyService.findQuestions();
	}
	
	@GetMapping("/questions/{questionId}")
	@LogMethodExecution
	public QuestionAnswerVO getQuestion(@PathVariable BigInteger questionId) {
		return surveyService.getQuestion(questionId);
	}

	@PostMapping("/questions")
	@ResponseStatus(HttpStatus.CREATED) //return 201 instead of 200
	@LogMethodExecution
	public QuestionVO addQuestion(@Valid @RequestBody QuestionVO question) {
		return surveyService.addQuestion(question);
	}

	@PutMapping("/questions")
	@LogMethodExecution
	public QuestionVO updateQuestion(@RequestBody QuestionVO question) {
		return surveyService.updateQuestion(question);
	}

	@DeleteMapping("/questions/{questionId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@LogMethodExecution
	public void deleteQuestion(@PathVariable @Min(1) BigInteger questionId) {
		surveyService.deleteQuestion(questionId);
	}

	@GetMapping("/answers")
	@LogMethodExecution
	public List<AnswerVO> findAnswers() {
		return surveyService.findAnswers();
	}
	
	@GetMapping("/answers/{answerId}")
	@LogMethodExecution
	public AnswerVO getAnswer(@PathVariable @Min(1) BigInteger answerId) {
		return surveyService.getAnswer(answerId);
	}

	@PostMapping("/answers")
	@ResponseStatus(HttpStatus.CREATED) //return 201 instead of 200
	@LogMethodExecution
	public AnswerVO addAnswer(@RequestBody AnswerVO question) {
		return surveyService.addAnswer(question);
	}

	@PutMapping("/answers")
	@LogMethodExecution
	public AnswerVO updateAnswer(@RequestBody AnswerVO question) {
		return surveyService.updateAnswer(question);
	}

	@DeleteMapping("/answers/{answerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@LogMethodExecution
	public void deleteAnswer(@PathVariable @Min(1) BigInteger answerId) {
		surveyService.deleteQuestion(answerId);
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED) //return 201 instead of 200
	@LogMethodExecution
	public SurveyVO submitSurvey(@RequestBody SurveyVO surveyIO) {
		return surveyService.addSurvey(surveyIO);
	}
	
}
