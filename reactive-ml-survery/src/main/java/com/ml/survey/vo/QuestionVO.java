package com.ml.survey.vo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.NotBlank;

/**
 * The persistent class for the question database table. 
 */
public class QuestionVO implements Serializable {


	private static final long serialVersionUID = 5957788012309493651L;

	private BigInteger questionId;
	private String askedBy;
	private Date askedOn;
	@NotBlank
	private String content;


	public QuestionVO() {
	}

	public QuestionVO(BigInteger questionId, String content,  String askedBy, Date askedOn) {
		super();
		this.questionId = questionId;
		this.askedBy = askedBy;
		this.askedOn = askedOn;
		this.content = content;
	}

	public BigInteger getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(BigInteger questionId) {
		this.questionId = questionId;
	}

	public String getAskedBy() {
		return this.askedBy;
	}

	public void setAskedBy(String askedBy) {
		this.askedBy = askedBy;
	}

	public Date getAskedOn() {
		return this.askedOn;
	}

	public void setAskedOn(Date askedOn) {
		this.askedOn = askedOn;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QuestionIO [");
		if (questionId != null) {
			builder.append("questionId=");
			builder.append(questionId);
			builder.append(", ");
		}
		if (askedBy != null) {
			builder.append("askedBy=");
			builder.append(askedBy);
			builder.append(", ");
		}
		if (askedOn != null) {
			builder.append("askedOn=");
			builder.append(askedOn);
			builder.append(", ");
		}
		if (content != null) {
			builder.append("content=");
			builder.append(content);
		}
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(askedBy, askedOn, content, questionId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof QuestionVO)) {
			return false;
		}
		QuestionVO other = (QuestionVO) obj;
		return Objects.equals(askedBy, other.askedBy) && Objects.equals(askedOn, other.askedOn)
				&& Objects.equals(content, other.content) && Objects.equals(questionId, other.questionId);
	}

	

}