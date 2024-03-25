package com.example.websocket.chat;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChatMessageRepository extends JpaRepository<ChatMessage,String> {
    List<ChatMessage> findByChatId(String s);
}
