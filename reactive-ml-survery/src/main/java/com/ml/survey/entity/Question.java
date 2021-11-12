package com.ml.survey.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Collections;
import java.util.Date;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

/**
 * The persistent class for the question database table. 
 */
@Entity
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="question_id")
	private BigInteger questionId;

	@Column(name="asked_by",updatable = false)
	private String askedBy = "annonymous";

	@Temporal(TemporalType.DATE)
	@Column(name="asked_on", updatable = false)
	private Date askedOn = new Date();

	@Lob
	private String content;

	@Column(name="count")
	private BigInteger viewCount;

	//bi-directional many-to-one association to Answer
	@OneToMany(mappedBy="question")
	private List<Answer> answers;

	public Question() {
	}

	public Question(String content) {
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

	public BigInteger getViewCount() {
		return this.viewCount;
	}

	public void setViewCount(BigInteger viewCount) {
		this.viewCount = viewCount;
	}

	public List<Answer> getAnswers() {
		return Collections.unmodifiableList(this.answers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(answers, askedBy, askedOn, content, questionId, viewCount);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Question)) {
			return false;
		}
		Question other = (Question) obj;
		return Objects.equals(answers, other.answers) && Objects.equals(askedBy, other.askedBy)
				&& Objects.equals(askedOn, other.askedOn) && Objects.equals(content, other.content)
				&& Objects.equals(questionId, other.questionId) && Objects.equals(viewCount, other.viewCount);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Question [");
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
			builder.append(", ");
		}
		if (viewCount != null) {
			builder.append("viewCount=");
			builder.append(viewCount);
			builder.append(", ");
		}
		if (answers != null) {
			builder.append("answers=");
			builder.append(answers);
		}
		builder.append("]");
		return builder.toString();
	}
	
	
}