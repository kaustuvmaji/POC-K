package com.ml.survey.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.ml.survey.common.LogMethodExecution;
import com.ml.survey.entity.Answer;
import com.ml.survey.entity.AnswerPK;
import com.ml.survey.entity.Question;
import com.ml.survey.entity.Survey;
import com.ml.survey.repository.AnswerRepository;
import com.ml.survey.repository.QuestionRepository;
import com.ml.survey.repository.SurveyRepository;
import com.ml.survey.vo.AnswerVO;
import com.ml.survey.vo.QuestionAnswerVO;
import com.ml.survey.vo.QuestionAnswerRefIO;
import com.ml.survey.vo.QuestionVO;
import com.ml.survey.vo.SurveyVO;

@Component
public class SurveyService {

	private static Logger logger = LoggerFactory.getLogger(SurveyService.class);

	@Autowired
	QuestionRepository questionRepository;

	@Autowired
	AnswerRepository answerRepository;

	@Autowired
	SurveyRepository surveyRepository;

	@Transactional(value = TxType.REQUIRED)
	@LogMethodExecution
	public QuestionVO addQuestion(QuestionVO questionIO) {
		logger.info("executing SurveyService.add(...)");
		Question entity = new Question(questionIO.getContent());
		if (StringUtils.hasLength(questionIO.getAskedBy()) && !"null".equalsIgnoreCase(questionIO.getAskedBy())) {
			entity.setAskedBy(questionIO.getAskedBy());
		}
		if (questionIO.getAskedOn() != null) {
			entity.setAskedOn(questionIO.getAskedOn());
		}
		Question e = questionRepository.save(entity);
		return new QuestionVO(e.getQuestionId(), e.getContent(), e.getAskedBy(), e.getAskedOn());
	}

	@Transactional(value = TxType.REQUIRED)
	@LogMethodExecution
	public QuestionVO updateQuestion(QuestionVO questionIO) {
		logger.info("executing SurveyService.update(...)");
		Question entity = new Question(questionIO.getContent());
		Question e = questionRepository.save(entity);
		return new QuestionVO(e.getQuestionId(), e.getContent(), e.getAskedBy(), e.getAskedOn());
	}

	@Transactional(value = TxType.REQUIRED)
	@LogMethodExecution
	public QuestionAnswerVO getQuestion(BigInteger questionId) {
		logger.info("executing SurveyService.getQuestion(...)");
		Question dbresponse = questionRepository.findById(questionId).orElse(null);
		QuestionAnswerVO response = new QuestionAnswerVO(dbresponse.getQuestionId(), dbresponse.getContent(),
				dbresponse.getAskedBy(), dbresponse.getAskedOn());
		questionRepository.updateViewCount();
		return response;
	}

	@LogMethodExecution
	public List<QuestionAnswerVO> findQuestions() {
		logger.info("executing SurveyService.findAll(...)");
		List<Question> dbresponse = (ArrayList<Question>) questionRepository.findAll();
		List<QuestionAnswerVO> response = new ArrayList<QuestionAnswerVO>();
		response = dbresponse.stream().filter(e -> StringUtils.hasLength(e.getContent()))
				.map(e -> new QuestionAnswerVO(e.getQuestionId(), e.getContent(), e.getAskedBy(), e.getAskedOn()))
				.collect(Collectors.toList());
		logger.info("db response", response);
		return response;
	}

	@Transactional(value = TxType.REQUIRED)
	@LogMethodExecution
	public void deleteQuestion(BigInteger questionId) {
		logger.info("executing SurveyService.findAll(...)");
		questionRepository.deleteById(questionId);
		logger.info("deleted successfully");
	}

	@Transactional(value = TxType.REQUIRED)
	@LogMethodExecution
	public AnswerVO addAnswer(AnswerVO answerIO) {
		logger.info("executing SurveyService.add(...)");
		Answer entity = new Answer(answerIO.getContent());
		Answer e = answerRepository.save(entity);
		return new AnswerVO(e.getId().getAnswerId(), e.getContent());
	}

	@Transactional(value = TxType.REQUIRED)
	@LogMethodExecution
	public AnswerVO updateAnswer(AnswerVO answerIO) {
		logger.info("executing SurveyService.update(...)");
		Answer entity = new Answer(answerIO.getContent());
		Answer e = answerRepository.save(entity);
		return new AnswerVO(e.getId().getAnswerId(), e.getContent());
	}

	@Transactional(value = TxType.REQUIRED)
	@LogMethodExecution
	public AnswerVO getAnswer(BigInteger answerId) {
		logger.info("executing SurveyService.getAnswer(...)");
//		Answer e = answerRepository.findById(new AnswerPK(answerId, null)).orElse(null);
		Answer e = answerRepository.findByAnswerId(answerId).orElse(null);
		AnswerVO response = new AnswerVO(e.getId().getAnswerId(), e.getContent());
		answerRepository.updateViewCount();
		return response;
	}

	@LogMethodExecution
	public List<AnswerVO> findAnswers() {
		List<Answer> dbresponse = (ArrayList<Answer>) answerRepository.findAll();
		List<AnswerVO> response = new ArrayList<AnswerVO>();
		response = dbresponse.stream().filter(e -> StringUtils.hasLength(e.getContent()))
				.map(e -> new AnswerVO(e.getId().getAnswerId(), e.getContent())).collect(Collectors.toList());
		logger.info("db response", response);
		return response;
	}

	@Transactional(value = TxType.REQUIRED)
	@LogMethodExecution
	public void deleteAnswer(BigInteger answerId) {
		answerRepository.deleteById(new AnswerPK(answerId, null));
		logger.info("deleted successfully");
	}

	@Transactional
	@LogMethodExecution
	public SurveyVO addSurvey(SurveyVO surveyIO) {
		// update survery table mapping.
		Survey survey = new Survey();
		survey.setCreatedBy("portal");
		survey.setCreatedOn(new Date());
		survey.setTopic("Hello");
		List<QuestionAnswerRefIO> questions = surveyIO.getQuestionAnswerBucket();
		Map<BigInteger, BigInteger> questionAnswerRef = new HashMap();
		for (QuestionAnswerRefIO question : questions) {
			questionAnswerRef.put(question.getQuestionId(), question.getAnswerId());
		}
		survey.setQuestionAnswersRef(questionAnswerRef);
		surveyRepository.save(survey);
		// update answer table.
		return surveyIO;
	}
}
