package com.ml.survey.vo;

import java.io.Serializable;
import java.math.BigInteger;

public class QuestionAnswerRefIO implements Serializable {
	
	private static final long serialVersionUID = -3126879886726452106L;
	
	private BigInteger questionId;
	private BigInteger answerId;
	public  BigInteger getQuestionId() {
		return questionId;
	}
	public void setQuestionId(BigInteger questionId) {
		this.questionId = questionId;
	}
	public BigInteger getAnswerId() {
		return answerId;
	}
	public void setAnswerId(BigInteger answerId) {
		this.answerId = answerId;
	}

}
