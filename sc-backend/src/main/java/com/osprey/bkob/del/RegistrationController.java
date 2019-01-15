//package com.osprey.bkob.controller;
//
//import com.osprey.bkob.domain.entities.User;
//import com.osprey.bkob.del.TokenDto;
//import com.osprey.bkob.dto.UserDto;
//import com.osprey.bkob.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//public class RegistrationController {
//
//    @Autowired
//    private UserService userService;
//
////    @GetMapping(value = "/registration/id")
////    public ResponseEntity<?> test() {
////         System.out.println("qwe");
////         return new ResponseEntity<>("OK. Controller is work.", HttpStatus.OK);
////    }
//
//
//    @RequestMapping(value = "/registration", method = RequestMethod.POST)
//    public ResponseEntity<?> createNewUser(UserDto userDto) {
//        User user = userService.signUp(userDto);
//
//        if(user != null) {
//            return new ResponseEntity<>(user, HttpStatus.CREATED);
//        }
//        return new ResponseEntity<>("User not created", HttpStatus.BAD_REQUEST);
//    }
//
//
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public ResponseEntity<?> loginUser(UserDto userDto) {
//        TokenDto tokenDto = userService.login(userDto);
//
//        if (userDto != null) {
//            return new ResponseEntity<>(tokenDto, HttpStatus.OK);
//        }
//        return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
//    }
//}
