package com.vvs.securityappbackend.service;

import com.vvs.securityappbackend.model.QuestionAndAnswer;

import reactor.core.publisher.Flux;

public interface QuestionAndAnswerService {
  public Flux<QuestionAndAnswer> getQuestionsAndAnswers();
}
