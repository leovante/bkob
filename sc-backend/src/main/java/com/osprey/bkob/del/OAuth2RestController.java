
//package com.osprey.bkob.controller;
//
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.security.Principal;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//import static com.osprey.bkob.controller.SingUpRestController.NAME_RESOURCE;
//@SpringBootApplication
//@EnableOAuth2Sso
//@RestController
//public class OAuth2RestController {
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = NAME_RESOURCE + " Данные получены"),
//            @ApiResponse(code = 400, message = NAME_RESOURCE + " Неправильные параметры"),
//            @ApiResponse(code = 404, message = NAME_RESOURCE + " Not Found")
//    })
//
//    @RequestMapping({ "/oauth", "/me" })   // через запятую указываем мэпинги
//    public Map<String, String> user(Principal principal) {
//        Map<String, String> map = new LinkedHashMap<>();
//        map.put("name", principal.getName());
//        return map;
//    }
