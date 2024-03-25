package com.example.websocket.chatRoom;

import com.example.websocket.chat.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;
    private final ChatMessageRepository chatMessageRepository;

    public Optional<String> getChatRoomId(
            String senderId,
            String recipientId,
            boolean createNewRoomIfNotExits
    ){
        return chatRoomRepository.findBySenderIdAndRecipientId(senderId,recipientId)
                .map(ChatRoom::getChatId)
                .or(()->{
                    if(createNewRoomIfNotExits){
                        var chatId = createChatId(senderId,recipientId);
                        return Optional.of(chatId);
                    }
                    return Optional.empty();
                });

    }

    private String createChatId(String senderId, String recipientId) {
        var chatId = String.format("%s_%s",senderId,recipientId);
        ChatRoom senderRecipient = ChatRoom.builder()
                .chatId(chatId)
                .recipientId(recipientId)
                .senderId(senderId)
                .build();
        ChatRoom recipientSender = ChatRoom.builder()
                .chatId(chatId)
                .recipientId(senderId)
                .senderId(recipientId)
                .build();
        return chatId;
    }
}
