package com.osprey.bkob.controller;

import com.osprey.bkob.domain.forms.UserRegistration;
import com.osprey.bkob.repository.UserRepository;
import com.osprey.bkob.service.UserService;
import com.osprey.bkob.service.signupService.SignUpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.osprey.bkob.controller.SingUpRestController.NAME_RESOURCE;

/**
 * Сохраниение пользователя через Rest;
 */
@RestController
@RequestMapping("/" + SingUpRestController.ROOT_PATH)
@Api(description = "/" + NAME_RESOURCE)
public class SingUpRestController {

    public static final String ROOT_PATH = "public";
    public static final String NAME_RESOURCE = "name_resurses";
    private final SignUpService signUpService;
    private final UserService userService;
    private final UserRepository repo;


    public SingUpRestController( SignUpService signUpService, UserService userService, UserRepository repo) {
        this.signUpService = signUpService;
        this.userService = userService;
        this.repo = repo;
    }

    /**
     * Сохранение пользователя через Rest, принимаем JSON;
     */
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = NAME_RESOURCE + " Данные получены"),
            @ApiResponse(code = 400, message = NAME_RESOURCE + " Неправильные параметры"),
            @ApiResponse(code = 404, message = NAME_RESOURCE + " Not Found")
    })

    @RequestMapping(path = "/signup", method = RequestMethod.POST, produces = "application/bkob.app-v1.0+json")

    public ResponseEntity<Object> signUp( UserRegistration userRegistration) {

        boolean bol =repo.findByEmail(userRegistration.getEmail()).isPresent() || !repo.findByuserName(userRegistration.getUserName()).isPresent();
        System.out.println(bol);
        if(bol){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            signUpService.signUp(userRegistration);
            return ResponseEntity.ok().build();
        }
    }
    @RequestMapping(path = "/activate/{code}",method = RequestMethod.POST, produces = "application/bkob.app-v1.0+json")
    public ResponseEntity<Object> activate(@PathVariable("code") String code) {
            boolean isActivated = userService.activateUser(code);
            if (isActivated) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
               return new ResponseEntity<>(HttpStatus.IM_USED);
            }
    }
}




