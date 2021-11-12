package com.ml.survey.repository;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ml.survey.entity.Survey;

@Repository
public interface SurveyRepository extends CrudRepository<Survey, BigInteger>{

}
