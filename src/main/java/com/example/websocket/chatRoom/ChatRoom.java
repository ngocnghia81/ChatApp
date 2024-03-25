package com.example.websocket.chatRoom;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ChatRoom {
    @Id
    @GeneratedValue
    private String id;
    private String chatId;
    private String senderId;
    private String recipientId;

}
