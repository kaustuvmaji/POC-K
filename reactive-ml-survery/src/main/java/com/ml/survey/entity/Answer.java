package com.ml.survey.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the answer database table.
 */
@Entity
@NamedQuery(name="Answer.findAll", query="SELECT a FROM Answer a")
public class Answer implements Serializable {

	private static final long serialVersionUID = -8395685113300109640L;

	@EmbeddedId
	private AnswerPK id;

	@Lob
	private String content;

	@Column(name="count")
	private BigInteger viewCount;

	//bi-directional many-to-one association to Question
	@ManyToOne
	@JoinColumn(name="question_id", insertable = false, updatable = false)
	private Question question;

	public Answer() {
	}
	
	public Answer(String content) {
		this.content = content;
	}

	public AnswerPK getId() {
		return this.id;
	}

	public void setId(AnswerPK id) {
		this.id = id;
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

	public Question getQuestion() {
		return this.question;
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, id, question, viewCount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Answer)) {
			return false;
		}
		Answer other = (Answer) obj;
		return Objects.equals(content, other.content) && Objects.equals(id, other.id)
				&& Objects.equals(question, other.question) && Objects.equals(viewCount, other.viewCount);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Answer [");
		if (id != null) {
			builder.append("id=");
			builder.append(id);
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
		if (question != null) {
			builder.append("question=");
			builder.append(question);
		}
		builder.append("]");
		return builder.toString();
	}


}