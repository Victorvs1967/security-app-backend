package com.vvs.securityappbackend.router;

import com.vvs.securityappbackend.model.Announcement;
import com.vvs.securityappbackend.model.QuestionAndAnswer;
import com.vvs.securityappbackend.repository.QuestionAndAnswerRepository;
import com.vvs.securityappbackend.security.JwtUtil;
import com.vvs.securityappbackend.service.AnnouncementService;
import com.vvs.securityappbackend.service.QuestionAndAnswerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class RestHandler {

  @Autowired
  private AnnouncementService announcementService;
  @Autowired
  private QuestionAndAnswerService questionAndAnswerService;
  @Autowired
  private JwtUtil jwtUtil;

  public Mono<ServerResponse> getAnnouncements(ServerRequest request) {
    String token = request.headers().firstHeader("authorization").substring(7);
    return jwtUtil.getAllClaimsFromToken(token)
      .flatMap(credentials -> ServerResponse
        .ok()
        .contentType(APPLICATION_JSON)
        .body(announcementService.getAnnouncements(), Announcement.class));
  }

  public Mono<ServerResponse> addAnnouncement(ServerRequest request) {    
    return request.bodyToMono(Announcement.class)
      .flatMap(announcement -> ServerResponse
        .ok()
        .contentType(APPLICATION_JSON)
        .body(announcementService.addAnnouncement(announcement), Announcement.class));
  }

  public Mono<ServerResponse> getQuestionsAndAnswers(ServerRequest request) {
    String token = request.headers().firstHeader("authorization").substring(7);
    return jwtUtil.getAllClaimsFromToken(token)
        .flatMap(credentials -> ServerResponse
            .ok()
            .contentType(APPLICATION_JSON)
            .body(questionAndAnswerService.getQuestionsAndAnswers(), QuestionAndAnswer.class));
  }

  public Mono<ServerResponse> addQuestionAndAnswer(ServerRequest request) {
    return request.bodyToMono(QuestionAndAnswer.class)
      .flatMap(data -> ServerResponse
        .ok()
        .contentType(APPLICATION_JSON)
        .body(questionAndAnswerService.addQuestionAndAnswer(data), QuestionAndAnswer.class));
  }
}
