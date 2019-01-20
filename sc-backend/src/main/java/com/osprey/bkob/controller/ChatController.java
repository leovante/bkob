package com.osprey.bkob.controller;

import com.osprey.bkob.domain.entities.Greeting;
import com.osprey.bkob.domain.entities.HelloMessage;
import com.osprey.bkob.domain.entities.User;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authorization.AuthenticatedReactiveAuthorizationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@RestController
public class ChatController {


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    @CrossOrigin(origins = "*", maxAge = 3600,
            allowedHeaders={"x-auth-token", "x-requested-with", "x-xsrf-token"})
    public Greeting greeting(HelloMessage message,Authentication authentication)  throws Exception {
        Object user=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(user);
         return new Greeting( authentication.getName()+" : "+ HtmlUtils.htmlEscape(message.getName()) + "!");
    }


}
