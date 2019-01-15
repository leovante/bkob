//package com.osprey.bkob.del;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Service;
//
//@Service
//public class TickService {
//
//	@Autowired
//	private SimpMessagingTemplate template;
//
//	@Scheduled(fixedDelay = 1000)
//	public void tick() {
//		template.convertAndSend("/topic/public");
//	}
//}
