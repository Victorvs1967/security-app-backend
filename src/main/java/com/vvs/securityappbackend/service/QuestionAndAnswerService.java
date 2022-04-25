package com.vvs.securityappbackend.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vvs.securityappbackend.model.QuestionAndAnswer;
import com.vvs.securityappbackend.model.Post;

import org.springframework.stereotype.Service;

@Service
public class QuestionAndAnswerService {
  
  public List<QuestionAndAnswer> getQuestionsAndAnswers() {
    Instant now = Instant.now();

    QuestionAndAnswer questionAndAnswer1 = QuestionAndAnswer.builder()
      .question(Post.builder()
        .text("Why we are going to fly to space?")
        .date(Date.from(now.minus(15, ChronoUnit.DAYS)))
        .user("ilovespace78")
        .build())
      .answer(Post.builder()
        .text("Because we love weightlessness.")
        .date(Date.from(now.minus(14, ChronoUnit.DAYS)))
        .user("Bob")
        .build())
      .build();
      
    QuestionAndAnswer questionAndAnswer2 = QuestionAndAnswer.builder()
      .question(Post.builder()
        .text("Why we are going to fly to the moon?")
        .date(Date.from(now.minus(5, ChronoUnit.DAYS)))
        .user("ilovethemoon88")
        .build())
      .answer(Post.builder()
        .text("Because we love rock.")
        .date(Date.from(now.minus(4, ChronoUnit.DAYS)))
        .user("Sheila")
        .build())
      .build();

    QuestionAndAnswer questionAndAnswer3 = QuestionAndAnswer.builder()
      .question(Post.builder()
        .text("Why we are going to fly to the Mars?")
        .date(Date.from(now.minus(1, ChronoUnit.DAYS)))
        .user("ilovemars98")
        .build())
      .answer(Post.builder()
        .text("Because we can.")
        .date(Date.from(now))
        .user("Hope")
        .build())
      .build();

    return new ArrayList<QuestionAndAnswer>() {{
      add(questionAndAnswer1);
      add(questionAndAnswer2);
      add(questionAndAnswer3);
    }};
  }
}
