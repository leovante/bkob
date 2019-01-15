package com.osprey.bkob.controller;


import com.osprey.bkob.domain.entities.TestUser;
import com.osprey.bkob.repository.UserTestRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.osprey.bkob.controller.SingUpRestController.NAME_RESOURCE;
@RestController
@RequestMapping("/" + SingUpRestController.ROOT_PATH)
@Api(description = "/" + NAME_RESOURCE)
public class TestController {

    public static final String ROOT_PATH = "public";

    @Autowired
    private UserTestRepository userTestRepository;

    @PostMapping(path = "/person")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody long addNewUser (@RequestParam String firstName, @RequestParam String lastName) {
        TestUser user = new TestUser(firstName, lastName);
        userTestRepository.save(user);


        return user.getId();
    }

    @GetMapping(path="/person/{id}")
    public @ResponseBody
    TestUser getUserById(@PathVariable("id") long id) {

        return userTestRepository.findById(id).get();
    }



}


