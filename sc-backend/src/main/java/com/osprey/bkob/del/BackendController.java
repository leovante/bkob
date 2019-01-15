package com.osprey.bkob.controller;

import com.osprey.bkob.domain.entities.User;
import com.osprey.bkob.repository.UserRepository;
import com.osprey.bkob.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
//@RequestMapping("/api")
public class BackendController {

	private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);

	public static final String HELLO_TEXT = "Test Hello from Spring Boot Backend!";

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/hello")
	public @ResponseBody String sayHello() {
		LOG.info("GET called on /hello resource");
		return HELLO_TEXT;
	}

	// ???
//	@RequestMapping(path = "/user", method = RequestMethod.POST)
//	@ResponseStatus(HttpStatus.CREATED)
//	public @ResponseBody Long addNewUser (@RequestParam String firstName, @RequestParam String lastName, @RequestParam String password, @RequestParam String email) {
//		User user = userService.create(firstName, lastName, password, email);
//		userRepository.save(user);
//
//		LOG.info(user.toString() + " successfully saved into DB");
//
//		return user.getUserId();
//	}

	@GetMapping(path="/user/{id}")
	public @ResponseBody
	User getUserById(@PathVariable("id") long id) {
		LOG.info("Reading user with id " + id + " from database.");
		return userRepository.findById(id).get();
	}
}