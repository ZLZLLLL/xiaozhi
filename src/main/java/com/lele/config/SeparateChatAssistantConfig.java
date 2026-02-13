package com.lele.config;

import com.lele.story.MongoChatMemoryStore;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeparateChatAssistantConfig {

    @Autowired
    private MongoChatMemoryStore MongoChatMemoryStore;

    @Bean
    public ChatMemoryProvider chatMemoryProvider() {

        return memoryId -> MessageWindowChatMemory
                .builder()
                .id(memoryId)
                .maxMessages(10)
                //.chatMemoryStore(new InMemoryChatMemoryStore())
                .chatMemoryStore(MongoChatMemoryStore)
                .build();
    }
}
