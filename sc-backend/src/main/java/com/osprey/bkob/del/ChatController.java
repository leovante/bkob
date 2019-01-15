//package com.osprey.bkob.del;
//
////import com.osprey.bkob.del.HelloMessage;
//
//import com.osprey.bkob.repository.ChatRepository;
//import com.osprey.bkob.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.web.bind.annotation.RestController;
//
//import org.springframework.web.util.HtmlUtils;
//
////@RestController
////public class ChatController {
////
////	@MessageMapping("/chat.sendMessage")
////	@SendTo("/topic/public")
////	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
////		return chatMessage;
////	}
////
////    @MessageMapping("/chat.addUser")
////    @SendTo("/topic/public")
////	public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
////		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
////		return chatMessage;
////	}
//
////@RestController
////class WebController {
////
////	@Autowired
////	public UserRepository userRepository;
////
////
////	@MessageMapping("/hello")
////	@SendTo("/topic/greetings")
////	public Greeting greeting(HelloMessage message, String username) throws Exception {
////
////		User firstname = userRepository.findByFirstName(username);
////
////		if (firstname != null) {
////			Thread.sleep(1000); // simulated delay
////			return new Greeting(firstname + " " + HtmlUtils.htmlEscape(message.getName()) + "!");
////		}
////		return null;
////
////
////	}
////
////
////
////
////	@MessageMapping("/chat.addUser")
////	@SendTo("/topic/public")
////	public ChatMessage addUser(@Payload ChatMessage chatMessage, UserDto userDto,
////							   SimpMessageHeaderAccessor headerAccessor) {
////		// Add username in web socket session
////		if (userDto.getFirstName() != null) {
////			headerAccessor.getSessionAttributes().put(userDto.getFirstName(), chatMessage.getSender());
////		}
////		return chatMessage;
////	}
////}
//
//
//@RestController
//public class ChatController {
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@Autowired
//    private ChatRepository chatRepository;
////
//	@MessageMapping("/hello")
//	@SendTo("/topic/greetings")
//	Chat getUserById(HelloMessage message) throws Exception {
//        Thread.sleep(1000);
//
//
//        return new Chat(HtmlUtils.htmlEscape(message.getName()) + "!");
//
//    }
//
//
////	@GetMapping(path = "/user/{id}")
////	public @ResponseBody
////	User getUserById(@PathVariable("id") long id) {
////
////		return userRepository.findById(id).get();
////	}
//
//}
//
//
//
//
//
//
//
