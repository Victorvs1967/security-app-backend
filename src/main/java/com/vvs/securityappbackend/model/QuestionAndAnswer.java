package com.vvs.securityappbackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@Document("questionsandanswers")
public class QuestionAndAnswer {
  
  @Id
  private String id;
  private Post question;
  private Post answer;
}
