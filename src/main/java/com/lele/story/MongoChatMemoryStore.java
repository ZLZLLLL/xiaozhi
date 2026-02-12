package com.lele.story;

import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MongoChatMemoryStore implements ChatMemoryStore {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 根据会话ID获取聊天消息
     * @param o 会话ID
     * @return 聊天消息列表
     */
    @Override
    public List<ChatMessage> getMessages(Object o) {
        return List.of();
    }

    /**
     * 新增或更新聊天记录
     * @param o 会话ID
     * @param list 消息列表
     */

    @Override
    public void updateMessages(Object o, List<ChatMessage> list) {

    }

    /**
     * 根据会话ID删除聊天消息
     * @param o 会话ID
     */
    @Override
    public void deleteMessages(Object o) {

    }
}
