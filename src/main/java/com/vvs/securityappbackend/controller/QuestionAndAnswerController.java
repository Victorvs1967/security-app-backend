package com.vvs.securityappbackend.controller;

import java.util.List;

import com.vvs.securityappbackend.model.QuestionAndAnswer;
import com.vvs.securityappbackend.service.QuestionAndAnswerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questionAndAnswer")
public class QuestionAndAnswerController {
  
  @Autowired
  private QuestionAndAnswerService questionAndAnswerService;

  @GetMapping("/")
  public List<QuestionAndAnswer> getQuestionAndAnswers() {
    return questionAndAnswerService.getQuestionsAndAnswers();
  }
}
