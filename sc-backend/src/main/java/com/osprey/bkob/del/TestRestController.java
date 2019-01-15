//package com.osprey.bkob.del;
//
//import com.osprey.bkob.service.UserService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class TestRestController {
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private UserRepository2 userRepository2;
//
//    private static final Logger LOG = LoggerFactory.getLogger(TestRestController.class);
////
////    @RequestMapping(value = "/test", method = RequestMethod.GET)
////    public ResponseEntity<List<User>> listAllUsers() {
////        List<User> users = userService.findAllUsers();
////
////        if (users.isEmpty()) {
////
////            return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
////        }
////
////        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
////    }
////}
//
////    @RequestMapping(value = "/user/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
////    public ResponseEntity<User> getUser(@PathVariable("name") String name) {
////        System.out.println("Fetching User with name " + name);
////        User user = userService.findByuserName(name);
////        if (user == null) {
////            System.out.println("User with name " + name + " not found");
////            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
////        }
////        return new ResponseEntity<User>(user, HttpStatus.OK);
////    }
////}
//
//@RequestMapping(path = "/user", method = RequestMethod.POST)
//@ResponseStatus(HttpStatus.CREATED)
//public @ResponseBody long addNewUser (@RequestParam String firstName, @RequestParam String lastName) {
//        User2 user2 = new User2(firstName, lastName);
//        userRepository2.save(user2);
//
//        LOG.info(user2.toString() + " successfully saved into DB");
//
//        return user2.getId();
//        }
//
//
//    @GetMapping(path="/user/{id}")
//    public @ResponseBody User2 getUserById(@PathVariable("id") long id) {
//        LOG.info("Reading user with id " + id + " from database.");
//        return userRepository2.findById(id).get();
//    }
//}
//
//
//
//
//
