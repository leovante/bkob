//package com.osprey.bkob.del;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.event.EventListener;
//import org.springframework.messaging.simp.SimpMessageSendingOperations;
//import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.messaging.SessionConnectedEvent;
//import org.springframework.web.socket.messaging.SessionDisconnectEvent;
//
////@Component
////public class WebSocketEventListener {
////	private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);
////
////    @Autowired
////    private SimpMessageSendingOperations messagingTemplate;
////
////    @EventListener
////    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
////        logger.info("Received a new web socket connection");
////    }
////
////    @EventListener
////    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
////        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
////
////        String username = (String) headerAccessor.getSessionAttributes().get("username");
////        if(username != null) {
////            logger.info("User Disconnected : " + username);
////
////            ChatMessage chatMessage = new ChatMessage();
////            chatMessage.setType(MessageType.LEFT);
////            chatMessage.setSender(username);
////
////            messagingTemplate.convertAndSend("/topic/public", chatMessage);
////        }
////    }
////}
//
//
//@Component
//public class WebSocketEventListener {
//    private static final Logger log = LoggerFactory.getLogger(EventListener.class);
//
//    @Autowired
//    private SimpMessageSendingOperations messageTemplate;
//
//    @EventListener
//    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
//        log.info("New web socket connection");
//    }
//
//    @EventListener
//    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
//        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
//
//        String username = (String) headerAccessor.getSessionAttributes().get("username");
//
//        if(username != null) {
//            log.info("User Disconnected: " + username);
//
//            Chat2 chatMessage = new Chat2();
//            chatMessage.setType(MessageType.LEFT);
//            chatMessage.setSender(username);
//
//            messageTemplate.convertAndSend("/topic/publicChatRoom", chatMessage);
//        }
//    }
//}
