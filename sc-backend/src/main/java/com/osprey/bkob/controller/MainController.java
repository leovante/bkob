package com.osprey.bkob.controller;


import com.osprey.bkob.config.token.TokenAuthentication;
import com.osprey.bkob.config.token.UserDetailsImpl;
import com.osprey.bkob.domain.entities.User;
import com.osprey.bkob.service.UserService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@RestController
@RequestMapping("/main")
public class MainController {
    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
         }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message =  " Данные получены"),
            @ApiResponse(code = 400, message =  " Неправильные параметры"),
            @ApiResponse(code = 404, message =  " Not Found")
    })

    @RequestMapping(path = "/profile/save",method = RequestMethod.POST, produces = "application/bkob.app-v1.0+json")
    public ResponseEntity<User> save(@RequestParam String city, @RequestParam String name, @RequestParam String phone,@RequestParam String skills , @RequestParam String about_me) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return userService.getByCountry(user,city, name, phone, skills, about_me);
    }

    @RequestMapping(path = "/profile/getInfo",method = RequestMethod.GET, produces = "application/bkob.app-v1.0+json")
    public ResponseEntity<User> getInfo() { //final HttpServletRequest request, Principal principal,
//        HttpSession session = request.getSession(true);
//        System.out.println(session.getAttribute("SPRING_SECURITY_CONTEXT"));
//        System.out.println(authentication.getUsername());
        User user = userService.getByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        System.out.println(user.getEmail());
       return new ResponseEntity<>( HttpStatus.OK);

//        try {
//             if (StringUtils.isEmpty(user)) {
//                return new ResponseEntity<>( HttpStatus.NOT_FOUND);
//            }
//            return new ResponseEntity<>(user, HttpStatus.OK);
//        }catch (Exception ex){
//            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
//        }
    }
}
