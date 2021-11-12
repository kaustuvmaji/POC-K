/**
 * 
 */
package com.ml.survey.vo;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.ml.survey.entity.Answer;

public class QuestionAnswerVO extends QuestionVO {
	
	private static final long serialVersionUID = 5453454161936032396L;
	
	private BigInteger viewCount;
	private List<Answer> answers;
	
	public QuestionAnswerVO() {
		super();
	}
	
	public QuestionAnswerVO(BigInteger questionId, String content, String askedBy, Date askedOn) {
		super(questionId, content, askedBy, askedOn);
	}
	
	public BigInteger getViewCount() {
		return viewCount;
	}
	public void setViewCount(BigInteger viewCount) {
		this.viewCount = viewCount;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(answers, viewCount);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof QuestionAnswerVO)) {
			return false;
		}
		QuestionAnswerVO other = (QuestionAnswerVO) obj;
		return Objects.equals(answers, other.answers) && Objects.equals(viewCount, other.viewCount);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QuestionIOResponse [");
		if (viewCount != null) {
			builder.append("viewCount=");
			builder.append(viewCount);
			builder.append(", ");
		}
		if (answers != null) {
			builder.append("answers=");
			builder.append(answers);
			builder.append(", ");
		}
		if (super.toString() != null) {
			builder.append("toString()=");
			builder.append(super.toString());
		}
		builder.append("]");
		return builder.toString();
	}
	
}
