//package com.osprey.bkob.del;


//@RestController
//public class MessageController {
//
//	private static final Logger LOG = LoggerFactory.getLogger(MessageController.class);
//
//	private final MessageService messageService;
//	private final UserService userService;
//
//	@Autowired
//	public MessageController(MessageService messageService, UserService userService) {
//		this.messageService = messageService;
//		this.userService = userService;
//	}
//
//	@RequestMapping(path = "/dialog/{id}", method = RequestMethod.GET)
//	public List<Message> getDialog(User profile, @PathVariable("id")Long id) {
//		LOG.debug("REST request to get dialog between id:{} and id:{} persons", profile.getUserId(), id);
//
//
//		Optional<User> interlocutor  = userService.findById(id);
//		if(interlocutor == null) {
//			LOG.debug("Interlocutor id:{} is not found", id);
//		}
//
//		return messageService.getDialog(profile, interlocutor);
//	}
//}
