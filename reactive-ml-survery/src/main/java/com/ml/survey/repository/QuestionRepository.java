package com.ml.survey.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ml.survey.entity.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, BigInteger> {

	@Modifying(clearAutomatically = true)
	@Query("update Question question set question.viewCount = viewCount +1")
	void updateViewCount();
}
