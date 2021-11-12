package com.ml.survey.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the survey database table.
 * 
 */
@Entity
@NamedQuery(name = "Survey.findAll", query = "SELECT s FROM Survey s")
public class Survey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "instance_id")
	private BigInteger instanceId;
	@Column(name = "topic")
	private String topic;
	@Column(name = "createdBy")
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "createdOn")
	private Date createdOn;

	@ElementCollection
	@MapKeyColumn(name = "question_id")
	@Column(name = "instance_id")
	@CollectionTable(name = "questionanswerref", joinColumns = @JoinColumn(name = "answer_id"))
	Map<BigInteger, BigInteger> questionAnswersRef = new HashMap<BigInteger, BigInteger>();

	public BigInteger getInstanceId() {
		return instanceId;
	}


	public void setInstanceId(BigInteger instanceId) {
		this.instanceId = instanceId;
	}


	public Map<BigInteger, BigInteger> getQuestionAnswersRef() {
		return questionAnswersRef;
	}


	public void setQuestionAnswersRef(Map<BigInteger, BigInteger> questionAnswersRef) {
		this.questionAnswersRef = questionAnswersRef;
	}


	public Survey() {
	}


	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

}