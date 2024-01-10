package com.group.ChatService.controller;

import com.group.ChatService.external.client.UserService;
import com.group.ChatService.model.User;
import com.group.ChatService.model.Message;
import com.group.ChatService.model.UserWithConversationData;
import com.group.ChatService.service.ChatService;
import com.group.ChatService.repository.MessageRepository;
import com.group.ChatService.service.TypeUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.bson.types.ObjectId;
import java.util.List;

@RestController
@RequestMapping("/api/v1/conversation")
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ChatService chatService;

    @Autowired
    private UserService userService;

    @MessageMapping("/room/{conversationId}/sendMessage")
    public Message sendMessage(@DestinationVariable String conversationId, @Payload Message chatMessage) {
        // Save the message
        Message savedMessage = messageRepository.save(chatMessage);
        // Handle conversation
        chatService.handleConversationForMessage(savedMessage);
        // send to conversation channel
        simpMessagingTemplate.convertAndSend("/room/" + conversationId, savedMessage);
        // send to receiver notification channel
        String receiverId = chatMessage.getReceiverId().toString();
        simpMessagingTemplate.convertAndSend("/room/" + receiverId, savedMessage);

        return savedMessage;
    }

    @GetMapping("/messages")
    public List<Message> getConversationMessages(@RequestParam ObjectId user1Id, @RequestParam ObjectId user2Id) {
        return chatService.getConversationMessages(user1Id, user2Id);
    }

    @GetMapping("/id")
    public ResponseEntity<String> getConversationId(@RequestParam ObjectId user1Id, @RequestParam ObjectId user2Id) {
        String conversationId = chatService.getConversationId(user1Id, user2Id);
        if (conversationId != null) {
            // user2Id is currentChatUser.id
            chatService.markConversationAsRead(user2Id, new ObjectId(conversationId));
            return ResponseEntity.ok(conversationId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/chatting-room-user/{id}")
    public ResponseEntity<UserWithConversationData> getSingleUser(@PathVariable String id) {
        User user = userService.getSingleUser(id);
        UserWithConversationData userWithConversationData = new UserWithConversationData(user);
        return ResponseEntity.ok(userWithConversationData);
    }

    @GetMapping("/get-matched-users-with-conversation-data-service/{id}")
    public ResponseEntity<List<UserWithConversationData>> getMatchedUsersWithConversationData(@PathVariable String id){

        List<UserWithConversationData> userWithConversationData = chatService.getMatchedUsersWithConversationData(id);
        return ResponseEntity.ok(userWithConversationData);
    }

}