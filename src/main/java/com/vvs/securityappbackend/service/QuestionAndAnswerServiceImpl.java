package com.vvs.securityappbackend.service;

import java.time.Instant;
import java.util.Date;

import com.vvs.securityappbackend.model.Post;
import com.vvs.securityappbackend.model.QuestionAndAnswer;
import com.vvs.securityappbackend.repository.QuestionAndAnswerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class QuestionAndAnswerServiceImpl implements QuestionAndAnswerService {

  @Autowired
  private QuestionAndAnswerRepository questionAndAnswerRepository;

  @Override
  public Flux<QuestionAndAnswer> getQuestionsAndAnswers() {
    return questionAndAnswerRepository.findAll();
  }

  @Override
  public Mono<QuestionAndAnswer> addQuestionAndAnswer(QuestionAndAnswer questionAndAnswer) {
    Post question = questionAndAnswer.getQuestion();
    Post answer = questionAndAnswer.getAnswer();
    QuestionAndAnswer newQuestionAndAnswer = QuestionAndAnswer.builder()
      .question(Post.builder()
        .text(question.getText())
        .date(Date.from(Instant.now()))
        .user(question.getUser())
        .build())
      .answer(Post.builder()
        .text(answer.getText())
        .date(Date.from(Instant.now()))
        .user(answer.getUser())
        .build())
      .build();
    return questionAndAnswerRepository.save(newQuestionAndAnswer);
  }
  
}
