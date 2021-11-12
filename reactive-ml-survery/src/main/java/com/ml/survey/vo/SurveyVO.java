package com.ml.survey.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class SurveyVO implements Serializable {

	private static final long serialVersionUID = 8839878488068943195L;

	private String surveyInstanceId = UUID.randomUUID().toString();
	
	private List<QuestionAnswerRefIO> questionAnswerBucket ;

	public String getSurveyInstanceId() {
		return surveyInstanceId;
	}

	public void setSurveyInstanceId(String surveyInstanceId) {
		this.surveyInstanceId = surveyInstanceId;
	}

	public List<QuestionAnswerRefIO> getQuestionAnswerBucket() {
		return questionAnswerBucket;
	}

	public void setQuestionAnswerBucket(List<QuestionAnswerRefIO> questionAnswerBucket) {
		this.questionAnswerBucket = questionAnswerBucket;
	}

	@Override
	public int hashCode() {
		return Objects.hash(questionAnswerBucket, surveyInstanceId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof SurveyVO)) {
			return false;
		}
		SurveyVO other = (SurveyVO) obj;
		return Objects.equals(questionAnswerBucket, other.questionAnswerBucket)
				&& Objects.equals(surveyInstanceId, other.surveyInstanceId);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SurveyIO [");
		if (surveyInstanceId != null) {
			builder.append("surveyInstanceId=");
			builder.append(surveyInstanceId);
			builder.append(", ");
		}
		if (questionAnswerBucket != null) {
			builder.append("questionAnswerBucket=");
			builder.append(questionAnswerBucket);
		}
		builder.append("]");
		return builder.toString();
	} 
	
	

}
