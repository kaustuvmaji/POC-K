package com.ml.survey.vo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

import javax.validation.constraints.NotBlank;

public class AnswerVO implements Serializable {

	private static final long serialVersionUID = -8371841776697192853L;

	private BigInteger answerId;

	
	@NotBlank
	private String content;

	private BigInteger viewCount;

	public AnswerVO() {
	}

	public AnswerVO(BigInteger answerId, String content) {
		this.answerId = answerId;
		this.content = content;
	}

	public BigInteger getAnswerId() {
		return this.answerId;
	}

	public void setAnswerId(BigInteger answerId) {
		this.answerId = answerId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public BigInteger getViewCount() {
		return this.viewCount;
	}

	public void setViewCount(BigInteger viewCount) {
		this.viewCount = viewCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(answerId, content, viewCount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof AnswerVO)) {
			return false;
		}
		AnswerVO other = (AnswerVO) obj;
		return Objects.equals(answerId, other.answerId)&& Objects.equals(content, other.content)
				&& Objects.equals(viewCount, other.viewCount);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Answer [");
		if (answerId != null) {
			builder.append("answerId=");
			builder.append(answerId);
			builder.append(", ");
		}
		if (content != null) {
			builder.append("content=");
			builder.append(content);
			builder.append(", ");
		}
		if (viewCount != null) {
			builder.append("viewCount=");
			builder.append(viewCount);
			builder.append(", ");
		}
		builder.append("]");
		return builder.toString();
	}
}