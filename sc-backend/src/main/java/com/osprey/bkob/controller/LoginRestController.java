package com.osprey.bkob.controller;

import com.osprey.bkob.config.token.AuthToken;
import com.osprey.bkob.domain.forms.UserLogin;
import com.osprey.bkob.dto.UserDto;
import com.osprey.bkob.repository.UserRepository;
import com.osprey.bkob.service.signupService.LoginService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static com.osprey.bkob.controller.SingUpRestController.NAME_RESOURCE;

/**
 * Получение Token по UserLogin(пользователь и пароль);
 */
@RestController
@RequestMapping("/public/")
public class LoginRestController {
    private final LoginService loginService;

    private final UserRepository userRepository;

    public LoginRestController(LoginService loginService, UserRepository userRepository) {
        this.loginService = loginService;
        this.userRepository = userRepository;
    }

    /**
     * Проверить полученого пользователя;
     */
    @GetMapping("/currentUser")
    public UserDto isAuthenticated(final HttpServletRequest request) {
        String userName = ((User) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal()).getUsername();
        com.osprey.bkob.domain.entities.User user = userRepository.findByEmail(userName)
                .orElseThrow(() -> new UsernameNotFoundException("User " + userName + " not found"));
        return UserDto.builder().email(user.getEmail()).state(user.getState()).build();
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
    public ResponseEntity<AuthToken> login(UserLogin userLogin) {
        final AuthToken token = loginService.createToken(userLogin);
        final HttpHeaders httpHeaders = new HttpHeaders();
        if (token == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }else{
            httpHeaders.add(HttpHeaders.AUTHORIZATION, "Bearer " + token.getAccessToken());
            return new ResponseEntity<>(token, httpHeaders, HttpStatus.OK);
        }
    }

}