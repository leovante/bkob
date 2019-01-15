package com.osprey.bkob.controller;

import com.osprey.bkob.config.token.JWTConfigurer;
import com.osprey.bkob.config.token.JWTToken;
import com.osprey.bkob.domain.forms.UserLogin;
import com.osprey.bkob.service.signupService.LoginService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Получение Token по UserLogin(пользователь и пароль);
 */
import static com.osprey.bkob.controller.SingUpRestController.NAME_RESOURCE;
@RestController
@RequestMapping("/public/")
public class LoginRestController {
    private String loginUser;
    private final LoginService loginService;

    public LoginRestController(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * Проверить полученого пользователя;
     */
    @GetMapping("/login")
    public String isAuthenticated(final @RequestBody HttpServletRequest request) {
        this.loginUser = request.getRemoteUser();
        System.out.println("HHHHHHH:" + loginUser);
        return request.getRemoteUser();
    }

    /**
     * Получить токен по UserLogin;
     */
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = NAME_RESOURCE + " Данные получены"),
            @ApiResponse(code = 400, message = NAME_RESOURCE + " Неправильные параметры"),
            @ApiResponse(code = 404, message = NAME_RESOURCE + " Not Found")
    })

    @RequestMapping(path = "/login", method = RequestMethod.POST, produces = "application/bkob.app-v1.0+json")
    public ResponseEntity<JWTToken> login( UserLogin userLogin) {
            final String jwt = loginService.createToken(userLogin);
            final HttpHeaders httpHeaders = new HttpHeaders();
        if (jwt.equals("null")) {
            return new ResponseEntity<JWTToken>(HttpStatus.NOT_FOUND);
        }else{
            httpHeaders.add(JWTConfigurer.AUTHORIZATION_HEADER, "Bearer " + jwt);
            return new ResponseEntity<>(new JWTToken(jwt), httpHeaders, HttpStatus.OK);
        }
    }

}