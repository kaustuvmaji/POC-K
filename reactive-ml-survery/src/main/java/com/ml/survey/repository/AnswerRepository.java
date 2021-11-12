package com.ml.survey.repository;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ml.survey.entity.Answer;
import com.ml.survey.entity.AnswerPK;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, AnswerPK> {
	
	@Modifying(clearAutomatically = true)
	@Query("update Answer answer set answer.viewCount = viewCount +1")
	void updateViewCount();
	
	@Query("SELECT DISTINCT a FROM Answer a WHERE a.id.answerId = :answerId")
	Optional<Answer> findByAnswerId(@Param("answerId") BigInteger answerId);

}
