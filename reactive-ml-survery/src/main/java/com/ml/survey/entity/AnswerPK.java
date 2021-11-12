package com.ml.survey.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.*;

/**
 * The primary key class for the answer database table.
 * 
 */
@Embeddable
public class AnswerPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="answer_id")
	private BigInteger answerId;

	@Column(name="question_id")
	private BigInteger questionId = new BigInteger("0");

	public AnswerPK() {
	}
	
	public AnswerPK(BigInteger answerId, BigInteger questionId) {
		super();
		this.answerId = answerId;
		this.questionId = questionId;
	}

	public BigInteger getAnswerId() {
		return this.answerId;
	}
	public void setAnswerId(BigInteger answerId) {
		this.answerId = answerId;
	}
	public BigInteger getQuestionId() {
		return this.questionId;
	}
	public void setQuestionId(BigInteger questionId) {
		this.questionId = questionId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AnswerPK)) {
			return false;
		}
		AnswerPK castOther = (AnswerPK)other;
		return 
			this.answerId.equals(castOther.answerId)
			&& this.questionId.equals(castOther.questionId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.answerId.hashCode();
		hash = hash * prime + this.questionId.hashCode();
		
		return hash;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AnswerPK [");
		if (answerId != null) {
			builder.append("answerId=");
			builder.append(answerId);
			builder.append(", ");
		}
		if (questionId != null) {
			builder.append("questionId=");
			builder.append(questionId);
		}
		builder.append("]");
		return builder.toString();
	}
	
}