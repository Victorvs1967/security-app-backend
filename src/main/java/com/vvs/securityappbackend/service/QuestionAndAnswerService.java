package com.vvs.securityappbackend.service;

import com.vvs.securityappbackend.model.QuestionAndAnswer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface QuestionAndAnswerService {
  public Flux<QuestionAndAnswer> getQuestionsAndAnswers();
  public Mono<QuestionAndAnswer> addQuestionAndAnswer(QuestionAndAnswer questionAndAnswer);
}