package com.vvs.securityappbackend.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class RestRouter {
  
  @Bean
  public RouterFunction<ServerResponse> restRouterFunction(RestHandler restHandler) {
    return RouterFunctions
      .route(GET("/rest/api/announcements").and(accept(APPLICATION_JSON)), restHandler::getAnnouncements)
      .andRoute(POST("/rest/api/announcement").and(accept(APPLICATION_JSON)), restHandler::addAnnouncement)
      .andRoute(GET("/rest/api/questionandanswers").and(accept(APPLICATION_JSON)), restHandler::getQuestionsAndAnswers)
      .andRoute(POST("/rest/api/questionandanswer").and(accept(APPLICATION_JSON)), restHandler::addQuestionAndAnswer);
  }
}
