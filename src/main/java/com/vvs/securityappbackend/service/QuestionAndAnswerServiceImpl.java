package com.vvs.securityappbackend.service;

import com.vvs.securityappbackend.model.QuestionAndAnswer;
import com.vvs.securityappbackend.repository.QuestionAndAnswerRepository;

import org.springframework.beans.factory.annotation.Autowired;

import reactor.core.publisher.Flux;

public class QuestionAndAnswerServiceImpl implements QuestionAndAnswerService {

  @Autowired
  private QuestionAndAnswerRepository questionAndAnswerRepository;

  @Override
  public Flux<QuestionAndAnswer> getQuestionsAndAnswers() {
    return questionAndAnswerRepository.findAll();
  }
  
}
