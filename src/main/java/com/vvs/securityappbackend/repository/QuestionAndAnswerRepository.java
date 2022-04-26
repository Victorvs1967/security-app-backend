package com.vvs.securityappbackend.repository;

import com.vvs.securityappbackend.model.QuestionAndAnswer;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionAndAnswerRepository extends ReactiveMongoRepository<QuestionAndAnswer, String> {
  
}
